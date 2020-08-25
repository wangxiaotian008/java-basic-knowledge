package test.threadTest.threadExceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 虽然用try-catch捕获但是并没有捕获到 catch里并没有打印。
 * @author wangjq
 *
 */
public class ThreadTest {

	public static void main(String[] args) {
		// try catch是捕获不到异常的
//		try {
//			Thread thread = new Thread(new ThreadException01());
//			thread.start();
//			
//		} catch (Exception e) {
//			System.out.println("不打印所以捕获不到异常");
//		}
		// 使用处理器捕获异常
//		Thread thread = new Thread(new ThreadException01());
//		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//		thread.start();
//		
		System.out.println("使用线程池来捕获异常==============");
		ExecutorService exec1 = Executors.newCachedThreadPool();
        Runnable runnable = new ThreadException01();
        Thread t1 = new Thread(runnable);
        t1.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        exec1.execute(t1);
	}
}
