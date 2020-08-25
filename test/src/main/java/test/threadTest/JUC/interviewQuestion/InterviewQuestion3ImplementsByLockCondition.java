package test.threadTest.JUC.interviewQuestion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterviewQuestion3ImplementsByLockCondition {

	static int order =0; // 这个变量是为了保证三个线程有序运行
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();
		
		
		new Thread(()->{
			lock.lock();
			for (int i = 0; i < 50; i++) {
				if(order != 0) {
					try {
						conditionA.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("A");
				order=1;
				conditionB.signal();
			}
			lock.unlock();
		}).start();
		new Thread(()->{
			lock.lock();
			for (int i = 0; i < 50; i++) {
				if(order != 1) {
					try {
						conditionB.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				order = 2;
				System.out.println("B");
				conditionC.signal();
			}
			lock.unlock();
		}).start();
		new Thread(()->{
			lock.lock();
			for (int i = 0; i < 50; i++) {
				if(order != 2) {
					try {
						conditionC.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				order=0;
				System.out.println("C");
				conditionA.signal();
			}
			lock.unlock();
		}).start();

	}

}
