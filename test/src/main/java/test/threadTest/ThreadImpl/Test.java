package test.threadTest.ThreadImpl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的其中一种方法，实现callable接口, 实现callable可以直接获取返回结果。
 * 实现runnable接口也可以获取返回值，需要创建 new FutureTask<MyDemo>(runnable, myDemo); 第二个参数就是在run方法里被运算的对象。（一般不这样用）
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		MyDemo myDemo = new MyDemo();
		myDemo.setAge(0);
		myDemo.setName("aaabbb");
		MyThreadImplCallable<MyDemo> callable = new MyThreadImplCallable<MyDemo>(myDemo);
		FutureTask<MyDemo> futureTask = new FutureTask<MyDemo>(callable);
		Thread thread = new Thread(futureTask);
		thread.start();
		
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("callable end");
		
		MyThreadImplRunnable runnable = new MyThreadImplRunnable(myDemo);
		
		FutureTask<MyDemo> runnablefutureTask = new FutureTask<MyDemo>(runnable, myDemo);
		Thread runnableThread = new Thread(runnablefutureTask);
		runnableThread.start();
		
		try {
			System.out.println(runnablefutureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("runnable end");
		
	}

}
