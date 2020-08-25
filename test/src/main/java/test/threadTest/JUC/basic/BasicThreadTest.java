package test.threadTest.JUC.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadTest {

	public static void main(String[] args) {
		
		AtomicInteger integer = new AtomicInteger();
		
		integer.incrementAndGet();
		integer.incrementAndGet();
		
	}
}
