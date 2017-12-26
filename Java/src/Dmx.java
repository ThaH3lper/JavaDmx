
public class Dmx {
	
	/**
	 * Variables needs to be in sync with the library;
	 */
	private final static int RESPONSE_OK							= 1;
	private final static int RESPONSE_OPEN_ERROR 					= 2;
	private final static int RESPONSE_SET_CHARACTERISTICS_ERROR 	= 3;
	private final static int RESPONSE_SET_BAUD_RATE_ERROR 			= 4;
	
	private boolean mDebugMode = false;
	
    static {
    	try {
            System.loadLibrary("JavaDmxLib"); // used for tests. This library in classpath only
        } catch (UnsatisfiedLinkError e) {
            try {
                NativeUtils.loadLibraryFromJar("/natives/JavaDmxLib.dll"); // during runtime. .DLL within .JAR
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }
    
    public void setDebugMode(boolean active) {
    	mDebugMode = active;
    }
    
    public void setup(int device, int baudRate) throws DmxException {
    	final int status = setupNative(device, baudRate);
    	
		printDebug("Setup status responese: " + status);
    	
    	if (status == RESPONSE_OPEN_ERROR) {
    		throw new DmxException("Failed to open DMX device");
    	} else if (status == RESPONSE_SET_CHARACTERISTICS_ERROR) {
    		throw new DmxException("Failed to set data characteristics");
    	} else if (status == RESPONSE_SET_BAUD_RATE_ERROR) {
    		throw new DmxException("Failed to set baud rate");
    	}
    	
    	printDebug("Setup DMX device successfully");
    }
    
    public boolean send(byte[] bytes) {
    	boolean success = sendNaitive(bytes);
    	printDebug("Sent bytes " + (success ? "success" : "failed"));
    	return success;
    }
    
    private void printDebug(String message) {
    	if (mDebugMode) {
    		System.out.println(message);
    	}
    }
    
	private native int setupNative(int device, int baudRate);
	private native boolean sendNaitive(byte[] bytes);
	private native void closeNaitive();
}
