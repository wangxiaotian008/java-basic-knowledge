package test.threadTest.JUC.interviewQuestion;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterviewQuestion3ImplementsBySemaphore {

	public static void main(String[] args) throws InterruptedException {
		
		Semaphore semaphoreA = new Semaphore(1);
		Semaphore semaphoreB = new Semaphore(1);
		Semaphore semaphoreC = new Semaphore(1);
		
		// 开始只有A可以获取, BC都不可以获取, 保证了A最先执行
		semaphoreB.acquire();
		semaphoreC.acquire();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
					try {
						semaphoreA.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A");
					semaphoreB.release();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
					try {
						semaphoreB.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("B");
					semaphoreC.release();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
					try {
						semaphoreC.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("C");
					semaphoreA.release();
			}
		}).start();

	}

}
