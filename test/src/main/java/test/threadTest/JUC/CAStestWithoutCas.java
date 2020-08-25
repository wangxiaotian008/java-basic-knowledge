package test.threadTest.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CAStestWithoutCas {

	static int count =0;
	static Object object = new Object();
	public synchronized static void request() throws InterruptedException {
//		TimeUnit.MILLISECONDS.sleep(3);
		synchronized(object) {
			count = count + 1;
		}
		
//		int expect;
//		
//		while (!compareAndSwap(expect=getcount(), expect + 1)) {
//			
//		}
	}
	
	public synchronized static boolean compareAndSwap(int expect, int newcount) {
		if (getcount() == expect) {
			count = newcount;
			return true;
		}
		return false;
	}
	
	public static int getcount() { return count;}
		
	public static void main(String[] args) throws InterruptedException {
		Long start = System.currentTimeMillis();
		CountDownLatch countDownLatch = new CountDownLatch(100);
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				
				try {
					for (int j = 0; j < 10; j++) {
						
						request();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
				
			}).start();
		}
		countDownLatch.await();
		Long end = System.currentTimeMillis();
		
		System.out.println("cost time" + (end - start) + "count=" + count);

	}

}
