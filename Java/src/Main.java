public class Main {
	
    public static void main(String[] args) {
        Dmx dmx = new Dmx();
        dmx.setDebugMode(true);
        try {
			dmx.setup(0, 220000);
		} catch (DmxException e) {
			e.printStackTrace();
		}
        
        dmx.send(new byte[512]);
    }
}
