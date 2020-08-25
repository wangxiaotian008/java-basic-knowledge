package test.jvm.performanceMonitorAndErrorHandleTools;

public class JconsoleDeadLockThreadMonitorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object object0 = new Object();
		Object object1 = new Object();
		
		Thread thread0 = new Thread(()->{
			
			synchronized (object0) {
				synchronized (object1) {
					System.out.println("thred0");
				}
			}
			
		});
		thread0.start();
		Thread thread1 = new Thread(()->{
			
			synchronized (object1) {
				synchronized (object0) {
					System.out.println("thred0");
				}
			}
			
		});
		
		thread1.start();
		
	}
	
	

}

class SynAddRunable implements Runnable{

	@Override
	public void run() {
		
	}
	
}
