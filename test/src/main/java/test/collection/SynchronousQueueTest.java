package test.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * 通过调试后得出： 当使用SynchronousQueue的时候，如果先调用了put（或者是take）方法，那么该方法就会阻塞在那里，对应着再调用了take（或者put）之后就会继续向下运行。
 * 这个队列是没有大小的队列。当调add方法时被报java.lang.IllegalStateException: Queue full异常
 * @author Administrator
 *
 */
public class SynchronousQueueTest {

	public static void main(String[] args) {
		SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
		new Thread(()->{
			try {
				for (int i = 0; i < 10; i++) {
					
					queue.put(i);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"producer").start();;
		
		new Thread(()->{
			try {
				for (int i = 0; i < 10; i++) {
					
					System.out.println("消费消息=" + queue.take());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"consumer").start();;
	}
}
