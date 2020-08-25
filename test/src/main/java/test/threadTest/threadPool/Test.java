package test.threadTest.threadPool;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
//		Executors.newSingleThreadExecutor();
//		Executors.newScheduledThreadPool(1);
		
		System.out.println(1 << 29);
		System.out.println(1 & ~((1 << 29) - 1));
		
		ConcurrentSkipListSet aConcurrentSkipListSet;
		
		InheritableThreadLocal n;
	}
}
