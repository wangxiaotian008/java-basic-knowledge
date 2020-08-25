package test.threadTest.threadExceptionHandler;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 自定义 异常处理器
 * @author wangjq
 *
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		
		
		System.out.println("捕获到异常" + e);
	}

}
