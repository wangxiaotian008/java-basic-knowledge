package test.jvm.classloaderTest;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 输出结果为hello world 但是没有输出const class init。
 * ！！！原因是在编译阶段通过常量传播优化，已经将此常量的值“hello world” 存储到了NotInitialization类的常量池，
 * 以后NotInitialization对常量ConstClass.HEELO_WORLD的引用实际都被转化为NotInitialization类对自身常量池的引用
 * @author Administrator
 *
 */
public class NotInitialization {

	public static void main(String[] args) {
		System.out.println(ConstClass.HEELO_WORLD);
	}

}
