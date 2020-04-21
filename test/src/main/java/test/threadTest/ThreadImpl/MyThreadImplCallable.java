package test.threadTest.ThreadImpl;

import java.util.concurrent.Callable;

public class MyThreadImplCallable<V> implements Callable<V> {

	private MyDemo myDemo;
	
	public MyThreadImplCallable(MyDemo myDemo) {
		super();
		this.myDemo = myDemo;
	}

	@Override
	public V call() throws Exception {
		
		for (int i = 0; i < 100; i++) {
			myDemo.setAge(myDemo.getAge() +1);
		}
		myDemo.setName("callable");
		Thread.sleep(5000);
		return (V) myDemo;
	}

}
