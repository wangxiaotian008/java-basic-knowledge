package test.LockTest;

public class Test {

	public static void main(String[] args) {
//		Data data = new Data(10);
		LockData data = new LockData(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
//        new ReadThread(data).start();
//        new ReadThread(data).start();
//        new ReadThread(data).start();

        new WriteThread(data, "ABCDEFGHI").start();
        new WriteThread(data, "012345789").start();
	}

}
