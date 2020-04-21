package test.threadTest.ThreadVisibility;
/**
 * 对于多线程可见性的测试， 在我本地机器上的测试结果是，不管加不加volatile，另一个线程能立马可见第二个线程改变后的值
 * @author Administrator
 *
 */
public class VisibilityTest {

	public static Integer flag = 0;
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread1 begin while");
				long num = 0;
				while(flag == 5) {
					num ++;
					System.out.println(num);
				}
				
				System.out.println("thread1 end");
			}
		});
		
		try {
			thread1.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("begin set flag to true");
				setFlagTrue();
				
				System.out.println("thread2 end");
			}
		});

		thread1.start();
		thread2.start();
	}
	
	private static void setFlagTrue() {
		flag ++;
	}

}
