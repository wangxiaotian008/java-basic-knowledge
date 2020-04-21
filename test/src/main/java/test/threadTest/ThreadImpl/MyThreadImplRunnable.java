package test.threadTest.ThreadImpl;

public class MyThreadImplRunnable implements Runnable {

	private MyDemo myDemo;
	
	public MyThreadImplRunnable(MyDemo myDemo) {
		super();
		this.myDemo = myDemo;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			myDemo.setAge(myDemo.getAge() +1);
		}
		myDemo.setName("runable");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
