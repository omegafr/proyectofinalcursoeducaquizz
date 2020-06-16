package metodos;

public class SO {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
    public static String dir = System.getProperty("user.dir");

	
	 public static boolean isWindows() {

	        return (OS.indexOf("win") >= 0);

	    }


}
