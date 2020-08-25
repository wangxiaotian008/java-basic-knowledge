package test.jvm;

/**
 * java 使用的不是引用计数算法，下面这个例子 A和B 相互引用，虽然A和B都赋值为null,但是instance还是指向对象实例，但是gc后堆内存回收了，所以不是引用计数算法
 * @author Administrator
 *
 */
public class ReferenceCountingGC {

	public Object instance=null;
	
	private static final int _1MB = 1024*1024;
	
	private byte[] bigSize = new byte[2*_1MB];
	
	public static void main(String[] args) {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
	}
}
