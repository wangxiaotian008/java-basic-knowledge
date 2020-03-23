package test.LockTest;

/**
 * 该类的读写方法用synchronized关键字修饰后 可以达到线程 共享互斥的  目的，但是速度回很慢
 * @author wangjq
 *
 */
public class Data implements DataInterface{

	// 定义一个数组，往里面放数据
	private final char[] buffer;

	public Data(int size) {
		this.buffer = new char[size];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = '*';
		}
		
	}
	
	/**
	 * 读数据
	 * @return
	 */
	public synchronized String  read(){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < buffer.length; i++) {
			builder.append(buffer[i]);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	/**
	 * 写数据,给数据中的每个值都赋值相同的字符
	 */
	public synchronized void write(char ch){
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = ch;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
