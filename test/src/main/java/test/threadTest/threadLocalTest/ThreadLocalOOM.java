package test.threadTest.threadLocalTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * threadlocal 可能会有内存泄漏的问题内存泄漏，因为threadlocalmap里的key是软引用
 * 目前知道的是如果某个线程结束了则不会存在这个问题。
 * @author Administrator
 *
 */
public class ThreadLocalOOM {

//	new ThreadPoolex
	static int num =0;
	static ExecutorService ex =Executors.newFixedThreadPool(1);
	
	
	public static void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		Thread thread0 = new Thread(()->{
			threadLocal.set("thread0");
			num++;
			System.out.println("num="+num);
		},"thread0");
		
		for (int i = 1; i <= 3; i++) {
			
			ex.execute(thread0);
			if(i == 2) {
				
				System.gc();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("thread run times " + i);
		}
//		
	

	}

}
