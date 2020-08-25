package test.threadTest.JUC;

import java.util.concurrent.Semaphore;

/**
 * semaphore： 信号标，旗语；臂板信号装置。 构造方法Semaphore(int permits) 
 * 用于限流, 可以控制同时有permits个线程运行。 semaphore.acquire(); 获取许可 。semaphore.release();释放许可
 * @author Administrator
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		
		new Thread(()->{
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "获得许可");
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread0").start();
		
		new Thread(()->{
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "获得许可");
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread1").start();
		
		new Thread(()->{
			try {
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + "获得许可");
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread2").start();
	}

}
