package test.threadTest.threadExceptionHandler;

/**
 * 线程的run方法里直接抛出异常后，在执行该线程的代码里用try-catch来捕获，但是不能捕获到，
 * @author wangjq
 *
 */
public class ThreadException01 implements Runnable {

	@Override
	public void run() {
		try {
			
			System.out.println(1/0);
		} catch (Exception e) {
			throw e;
		}
	}

	
}
