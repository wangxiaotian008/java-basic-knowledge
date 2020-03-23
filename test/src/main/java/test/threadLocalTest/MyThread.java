package test.threadLocalTest;

/**
 * 想实现的功能是 每个线程自己计自己的数  每个线程互不干扰
 * 但是如果不加threadlocal的话  各个线程共用同一个变量
 * @author wangjq
 *
 */
public class MyThread implements Runnable {

	private Sequence sequence;
	
	public MyThread(Sequence sequence) {
		super();
		this.sequence = sequence;
	}

	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + sequence.getNumber());
			
		}
	}

}
