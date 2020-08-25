package test.threadTest.JUC.interviewQuestion;

/**
 * 1、实现一个容易，提供了两个方法，一个add,一个getSize。
		写两个线程，一个线程往容器加10个数据， 另一个线程时间监控元素的个数，当个数到达5个，线程2给出提示并结束。
 * 使用wait notify实现
 * @author Administrator
 *
 */
public class InterviewQuestion1ImplementsByWaitAndNotify {

	public static void main(String[] args) {
		MycollectionForQuestion1 mycollection = new MycollectionForQuestion1();
		Class<InterviewQuestion1ImplementsByWaitAndNotify> clazz =InterviewQuestion1ImplementsByWaitAndNotify.class;
		new Thread(()->{
			synchronized (clazz) {
				if (mycollection.getSize() != 5) {
					try {
						clazz.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("get size 5 end");
				clazz.notify();
				
			}
		}).start();
		
		new Thread(()->{
			synchronized (clazz) {
				for (int i = 0; i < 10; i++) {
					mycollection.add(new Object());
					System.out.println("add object=" + i);
					if (mycollection.getSize() == 5) {
						clazz.notify();
						try {
							clazz.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}).start();

	}

}
