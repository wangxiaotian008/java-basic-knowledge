package test.threadTest.JUC;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的计数器更像一个阀门，需要所有线程(示例中是5个）都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用
 * @author Administrator
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->{
			// int j=1/0; 该代码被打开后，会抛出BrokenBarrierException
			System.out.println("来5个执行一次");
		});
		
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				try {
					// 业务逻辑
					System.out.println(Thread.currentThread().getName());
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					
					e.printStackTrace();
				}
			},"thread"+i).start();
		}
		
	}

}
