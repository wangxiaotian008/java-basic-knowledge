package test.threadTest.threadLocalTest;

/**
 * 父线程和子线程之间共享数据InheritableThreadLocal
 * @author Administrator
 *
 */
public class InheritableThreadLocalTest {

	public static void main(String[] args) {
		
		new Thread(()->{
			InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();
			inheritableThreadLocal.set("parent_str");
			new Thread(()->{
				System.out.println("子线程获取到的父线程值:" + inheritableThreadLocal.get());
			},"childThread").start();
		},"parentThread").start();
		
//		testWithOutThreadPool(inheritableThreadLocal);

	}
	
	public static void testWithOutThreadPool(InheritableThreadLocal<String> inheritableThreadLocal) {
		
		new Thread(()->{
			System.out.println("子线程获取到的父线程值:" + inheritableThreadLocal.get());
		},"childThread").start();
	}

}
