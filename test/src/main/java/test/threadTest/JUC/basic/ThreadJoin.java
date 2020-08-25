package test.threadTest.JUC.basic;

/**
 * join方法是插队的意思，就是插队的线程先运行，运行完了外面的线程再接着运行。
 * 比如例子中， thread0 join到thread1中，那么thread0 先运行完，thread1再运行。
 * @author Administrator
 *
 */
public class ThreadJoin {

	public static void main(String[] args) {
		Thread thread0 = new Thread(()-> {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread0") ;
		
		Thread thread1 = new Thread(new MyThread(thread0), "thread1") ;
		thread0.start();
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");

	}

}

class MyThread implements Runnable{

	Thread thread;
	
	public MyThread(Thread thread) {
		super();
		this.thread = thread;
	}


	@Override
	public void run() {
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
	}
	
}
