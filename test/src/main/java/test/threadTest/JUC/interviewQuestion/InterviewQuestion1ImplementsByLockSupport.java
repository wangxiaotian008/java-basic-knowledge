package test.threadTest.JUC.interviewQuestion;

import java.util.concurrent.locks.LockSupport;

/**
 * 1、实现一个容易，提供了两个方法，一个add,一个getSize。
		写两个线程，一个线程往容器加10个数据， 另一个线程时间监控元素的个数，当个数到达5个，线程2给出提示并结束。
 * 使用LockSupport实现
 * @author Administrator
 *
 */
public class InterviewQuestion1ImplementsByLockSupport {

	static Thread t1=null;
	static Thread t2=null;
	public static void main(String[] args) {
		MycollectionForQuestion1 mycollection = new MycollectionForQuestion1();
//		impl1(mycollection);
		impl2(mycollection);
	}
	
	/**
	 * 这种实现方式有问题，有可能会输出下面的结果。
	 * 原因如下：
	 *  ①如果是线程1先运行LockSupport.park();那么线程1就会挂起，然后线程2开始运行，并且size是5的时候线程1解除阻塞。
	 * 		但是如果t2线程占有CPU时间长，那么线程2比线程1运行的快，就不会在线程1打印完提示后线程2再继续运行。
	 *  ②如果是线程2先运行LockSupport.unpark(t1); 那么线程1里的LockSupport.park();就会失效。 
	 *  最终实现是impl2方法。
	 * add object=0
		add object=1
		add object=2
		add object=3
		add object=4
		add object=5
		add object=6
		add object=7
		add object=8
		add object=9
		get size 5 end
	 */
	static void impl1(MycollectionForQuestion1 mycollection) {
		t1 = new Thread(()->{
			if (mycollection.getSize() != 5) {
				LockSupport.park();
			}
			System.out.println("get size 5 end");
				
		});
		
		t2 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				mycollection.add(new Object());
				System.out.println("add object=" + i);
				if (mycollection.getSize() == 5) {
					LockSupport.unpark(t1);
				}
			}
		});
		
		t1.start();
		t2.start();
	}
	
	static void impl2(MycollectionForQuestion1 mycollection) {
		t1 = new Thread(()->{
			if (mycollection.getSize() != 5) {
				LockSupport.park();
			}
			System.out.println("get size 5 end");
			LockSupport.unpark(t2);
				
		});
		
		t2 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				mycollection.add(new Object());
				System.out.println("add object=" + i);
				if (mycollection.getSize() == 5) {
					LockSupport.unpark(t1);
					LockSupport.park();
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
