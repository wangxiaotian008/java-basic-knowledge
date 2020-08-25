package test.threadTest.ReentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 当参数值是true时是公平锁，公平锁的意思是使用该锁对象的所有线程中等待时间最长的线程先被唤醒。
 * tips： 这个公平锁没法写代码验证，因为无法控制线程等待获取锁时间的长短。
 * 
 * 可以debug查看代码，来查看Reentrantlock实现原理。 volatile —— CAS实现。
 * @author Administrator
 *
 */
public class ReentrantLockTest {

	
	public static void main(String[] args) {
		Lock lock = new ReentrantLock(true);
		
		new Thread(()->{
			try {
				lock.lock();
				
			} finally {
				lock.unlock();
			}
		},"thread0").start();
		
		new Thread(()->{
			try {
				lock.lock();
			} finally {
				lock.unlock();
			}
		},"thread1").start();
		
		new Thread(()->{
			try {
				lock.lock();
			} finally {
				lock.unlock();
			}
		},"thread2").start();

	}

}


