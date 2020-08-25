package test.threadTest.ReentrantLockTest;

public class ReadThread extends Thread {
	
	private DataInterface data;
	
	public ReadThread(DataInterface data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
//		while(true){
//			System.out.println(Thread.currentThread().getName() + "=>" + data.read());
//		}
		while(true){
			 long begin = System.currentTimeMillis();
	            for (int i = 0; i < 10; i++) {
	                String result = data.read();
	                System.out.println(Thread.currentThread().getName() + " => " + result);
	            }
	            long time = System.currentTimeMillis() - begin;
	            System.out.println(Thread.currentThread().getName() + " -- " + time + "ms");
		}
	}

	
}
