package test.jvm.performanceMonitorAndErrorHandleTools;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JconsoleThreadMonitorTest {

	public static void createBusyThread() {
		Thread thread = new Thread(()->{
			
			while(true)
				;
			
		},"testBusyThread") ;
		thread.start();
	}
	
	public static void createLockThread(final Object lock) {
		Thread thread = new Thread(()->{
			
			synchronized (lock) {
				try {
					lock.wait();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		},"testLockThread") ;
		thread.start();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		bReader.readLine();
		createBusyThread();
		bReader.readLine();
		Object lock = new Object();
		createLockThread(lock);
		
	}
}
