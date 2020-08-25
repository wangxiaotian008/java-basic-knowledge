package test.jvm.classloaderTest;

/**
 * 如果HEELO_WORLD不是常量，那么当ConstClass.HEELO_WORLD被调用时，父类的静态代码块也会被初始化（即父类也会被加载）
 * @author Administrator
 *
 */
public class ConstClass extends SuperClass {

	static {
		System.out.println("const class init");
	}
	
	public static final String HEELO_WORLD="hello world";
}
