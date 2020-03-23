package test.threadLocalTest;

public class Test {

	public static void main(String[] args) {
		Sequence sequence = new SequenceImpl();

		Runnable myThread1 = new MyThread(sequence);
		Runnable myThread2 = new MyThread(sequence);
		Runnable myThread3 = new MyThread(sequence);
		new Thread(myThread1,"myThread1").start();
		new Thread(myThread2,"myThread2").start();
		new Thread(myThread3,"myThread3").start();
	}

}
