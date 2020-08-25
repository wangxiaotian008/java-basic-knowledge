package test.threadTest.ReentrantLockTest;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock的condition实现生产者消费者
 * @author Administrator
 *
 */
public class ReentrantLockImplProducerConsumerWithCondition {

	static ArrayList<String> list = new ArrayList<String>(10);
	static ReentrantLock lock = new ReentrantLock();
	static Condition producerCondition = lock.newCondition();
	static Condition consumerCondition = lock.newCondition();
	public static void main(String[] args) {
		while (true) {
			
			for (int i = 0; i < 2; i++) {
				new Thread(()->{
					produce();
				}).start();
			}
			
			for (int i = 0; i < 2; i++) {
				new Thread(()->{
					consume();
				}).start();
			}
		}
	}
	
	public static void produce() {
		
		try {
			lock.lock();
			while (list.size()==10) {
				System.out.println("产品满了！！！");
				producerCondition.await();
			}
			String str = new String("test");
			System.out.println("生产消息" + str);
			list.add(str);
			consumerCondition.signalAll();
				
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}
	
	public static void consume() {
		try {
			lock.lock();
			while (list.size()==0) {
				System.out.println("没产品了！！！");
				consumerCondition.await();
			}
			System.out.println("消费消息" + list.remove(0));
			producerCondition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

}
