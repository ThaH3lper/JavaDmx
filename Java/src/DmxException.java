
@SuppressWarnings("serial")
public class DmxException extends Throwable {
	
	private String mErrorMessage;
	
	public DmxException(String errorMessage) {
		mErrorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return mErrorMessage;
	}
}
