package test.threadTest.JUC.interviewQuestion;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterviewQuestion3ImplementsByBasicLock {
	//通过JDK5中的锁来保证线程的访问的互斥, 也可以使用synchronized
    private static Lock lock = new ReentrantLock();
    private static int state = 0;
    
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    
    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                lock.lock();
                if (state % 3 == 0) {
                    System.out.print("A");
                    state++;
                    i++;
                }
                lock.unlock();
            }
            countDownLatch.countDown();
        }
    }
    
    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                lock.lock();
                if (state % 3 == 1) {
                    System.out.print("B");
                    state++;
                    i++;
                }
                lock.unlock();
            }
            countDownLatch.countDown();
        }
    }
    
    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                lock.lock();
                if (state % 3 == 2) {
                    System.out.print("C");
                    state++;
                    i++;
                }
                lock.unlock();
            }
            countDownLatch.countDown();
        }
    }
    
    public static void main(String[] args) {
    	Long start = System.currentTimeMillis();
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
        try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    
}