package test.threadLocalTest;

public class SequenceImpl implements Sequence {

	/**
	 *  * 想实现的功能是 每个线程自己计自己的数  每个线程互不干扰
	 * 但是如果不加threadlocal的话(情况①)  各个线程共用同一个变量
	 * *****ThreadLocal 重写initialValue方法来初始化。
	 */
	// ① public static int initValue = 0;
	public ThreadLocal<Integer> initValue = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 0;
		};
	};	
	@Override
	public int getNumber() {
		initValue.set(initValue.get() + 1);
		return initValue.get();
	}

}
