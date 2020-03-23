package test.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockData implements DataInterface{

	// 定义锁
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	

	// 定义一个数组，往里面放数据
	private final char[] buffer;

	public LockData(int size) {
		this.buffer = new char[size];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = '*';
		}
		
	}
	
	
	/**
	 * 读数据
	 * @return
	 */
	public String  read(){
		readLock.lock();
		try{
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
		}finally{
			readLock.unlock();
		}
	}
	
	/**
	 * 写数据,给数据中的每个值都赋值相同的字符
	 */
	public void write(char ch){
		writeLock.lock();
		try{
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = ch;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}finally{
			writeLock.unlock();
		}
	}


}
