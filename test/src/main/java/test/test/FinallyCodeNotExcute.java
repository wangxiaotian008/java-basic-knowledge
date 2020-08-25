package test.test;

/**
 * finally 代码块不执行的情况:
 * 1.虚拟机退出，finally不执行
 * 2.程序所在的线程死亡（例如：可以创建守护线程来实现，当非守护线程结束后，守护线程会被直接kill掉）注：如果当前线程调用了stop interrupt 都还是会执行finally块。
 * @author Administrator
 *
 */
public class FinallyCodeNotExcute {

	public static void main(String[] args)   {
		
		System.out.println("finally code test");
//		virtualVmExit();
		
		Thread thread = new Thread(new MyThread());
		thread.setDaemon(true);
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 虚拟机退出。 输出结果：执行try代码
	 */
	public static void virtualVmExit() {
		try {
			System.out.println("执行try代码");
			System.exit(0);
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("虚拟机退出，finally不执行");
		}
	}

}

/**
 * 2.程序所在的线程死亡
 * @author Administrator
 *
 */
class MyThread implements Runnable{

	@Override
	public void run() {
		try {
			System.out.println("线程执行try代码");
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("线程死亡，finally不执行");
		}
		
	}
	
	
}
