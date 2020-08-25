package test.threadTest.JUC.basic;

public class ThreadInterrupt {

	public static void main(String[] args) {
		new Thread(()->{
			
			Thread currentThread = Thread.currentThread();
			System.out.println(currentThread.getName());
			currentThread.interrupt();
			System.out.println(currentThread.isInterrupted());
			
		},"a").start();
	}
}
