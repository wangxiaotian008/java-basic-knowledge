package test.threadTest.JUC;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch(int num); CountDownLatch.await()方法会则塞，直到调用CountDownLatch.countDown()使num递减直到为0，await就会打开。
 * tips: CountDownLatch 和 CyclicBarrier 类似，
 * 		但是CyclicBarrier更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用。
 * 		而CountdownLatch不可以，只能只用一次
 * @author Administrator
 *
 */
public class CountdownLatchTest {

	public static void main(String[] args) {
		CountDownLatch countdownLatch = new CountDownLatch(3);
		new Thread(()->{
			countdownLatch.countDown();
			System.out.println("thread1 countdown");
		}).start();
		new Thread(()->{
			countdownLatch.countDown();
			System.out.println("thread2 countdown");
		}).start();
		
		new Thread(()->{
			countdownLatch.countDown();
			System.out.println("thread3 countdown");
		}).start();
		
		try {
			// 只要其中一个thread执行了countdown方法，值就会变为0，await就会执行了。
			System.out.println("main thread block start");
			countdownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread end");

	}

}
