package test.threadTest.ReentrantLockTest;

public class WriteThread extends Thread {
	
	private final DataInterface data;
    private final String str;
    private int index = 0;

    public WriteThread(DataInterface data, String str) {
        this.data = data;
        this.str = str;
    }

    @Override
    public void run() {
        while (true) {
            char c = next();
            data.write(c);
        }
    }

    private char next() {
        char c = str.charAt(index);
        index++;
        if (index >= str.length()) {
            index = 0;
        }
        return c;
    }

}
