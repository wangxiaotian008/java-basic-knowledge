package test.jvm.classloaderTest;

import java.io.IOException;
import java.io.InputStream;

public class UserDefinedClassloader {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class clazz = UserDefinedClassloader.class;
		System.out.println("classloader is :"+ clazz.getClassLoader().toString()); //classloader 是 sun.misc.Launcher$AppClassLoader@73d16e93
		ClassLoader classLoader = new ClassLoader() {

			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				
				String filename = name.substring(name.lastIndexOf(".")+1) + ".class";
				InputStream in = this.getClass().getResourceAsStream(filename);
				if (in == null) {
					return super.loadClass(name);
					
				}
				try {
					byte[] bytes = new byte[in.available()];
					in.read(bytes);
					return defineClass(name, bytes, 0, bytes.length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
			
		};
		
		Object obj = classLoader.loadClass("test.jvm.classloaderTest.UserDefinedClassloader");
		
		System.out.println(obj.getClass());
		System.out.println(obj instanceof test.jvm.classloaderTest.UserDefinedClassloader);// 因为是两个类加载器加载的，所以结果是false
		
		/**测试下面这段代码之前需要把上面的加载类先注释掉，否则报错因为如果被同一个类只能被同一个类加载器加载一次
		 * Exception in thread "main" java.lang.LinkageError: loader (instance of  test/jvm/classloaderTest/UserDefinedClassloader$1): attempted  duplicate class definition for name: "test/jvm/classloaderTest/UserDefinedClassloader"
			at java.lang.ClassLoader.defineClass1(Native Method)
			at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
			at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
			at test.jvm.classloaderTest.UserDefinedClassloader$1.loadClass(UserDefinedClassloader.java:26)
			at test.jvm.classloaderTest.UserDefinedClassloader.main(UserDefinedClassloader.java:41)
		 */
		Class obj1 = classLoader.loadClass("test.jvm.classloaderTest.UserDefinedClassloader");
		System.out.println(obj1.getClassLoader().toString()); //  classloader 是 test.jvm.classloaderTest.UserDefinedClassloader$1@7852e922
	}
}
