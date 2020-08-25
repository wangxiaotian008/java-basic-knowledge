package test.jvm.classloaderTest;

public class SuperClass {

	static {
		System.out.println("super class init");
	}
	
	public static String SUPER="SUPER CLASS";
}
