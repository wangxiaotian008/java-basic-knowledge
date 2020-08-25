package test.threadTest.ThreadVisibility;
/**
 * 对于多线程可见性的测试， 在我本地机器上的测试结果是，不管加不加volatile，另一个线程能立马可见第二个线程改变后的值
 * 原因找到了，不能自己debug否则就会出现上面的问题！！！
 * @author Administrator
 *
 */
public class VisibilityTest {

	private static boolean flag = true;
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread1 begin while");
				flag = false;
				
				System.out.println("thread1 end");
			}
		});
		
		Thread thread2 = new Thread(()->{
			System.out.println("m start");
			while (flag) {
				
			}
			System.out.println("m end");
		});
		
		thread2.start();
		Thread.sleep(5000);
		thread1.start();
		
	}
}
