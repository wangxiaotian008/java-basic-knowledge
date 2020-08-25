package test.JOL;

import org.openjdk.jol.info.ClassLayout;


/**-XX:-UseCompressedOops 可以关闭压缩
 * java 普通对象的内存布局： 对象头（markword 8bytes 和 类型指针（T.class）），实例数据，对齐填充（一个对象大小必须是8字节的倍数）
 * java.lang.Object object internals:
	 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1) // 
	      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0) // markword 8 bytes
	      8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397) // 类型指针 4 bytes( jdk1.8 以后自动压缩，只有64位hotspot有压缩)
	     12     4        (loss due to the next object alignment)  // 对其填充 4 bytes
	Instance size: 16 bytes  // 一共是是16字节
	Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
	
	java 数组的内存布局：对象头（markword 8bytes 和 类型指针（T.class） 和 数组长度），实例数据，对齐填充（一个对象大小必须是8字节的倍数）
 * @author Administrator
 *
 */
public class JOLTest {

	
	/**
	 * 没有锁的状态
	 */
	
	public static void main(String[] args) {
		Object object = new Object();
//        System.out.println("hash: " + object.hashCode());
        System.out.println(ClassLayout.parseInstance(object).toPrintable());
        
        T t = new T();
        System.out.println(ClassLayout.parseInstance(t).toPrintable()); 
        // 与object类似，不过实例对象里有个int变量，要占4bytes，加上前面的8字节正好16，所以不需要对齐填充
        /**
         * test.JOL.T object internals:
			 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
			      0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
			      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
			      8     4        (object header)                           03 13 01 20 (00000011 00010011 00000001 00100000) (536941315)
			     12     4    int T.a                                       0
			Instance size: 16 bytes
			Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */
        
        int[] a = new int[30];
        System.out.println(ClassLayout.parseInstance(a).toPrintable()); 
        
		/**
		 * [I object internals:
			 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
			      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
			      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
			      8     4        (object header)                           6d 01 00 20 (01101101 00000001 00000000 00100000) (536871277)
			     12     4        (object header)                           1e 00 00 00 (00011110 00000000 00000000 00000000) (30)
			     16   120    int [I.<elements>                             N/A
			Instance size: 136 bytes
			Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
		 */
        
        String ss = "ss";
        System.out.println(ClassLayout.parseInstance(ss).toPrintable()); 
	}
}


class T {
	
	private int a;
}

class arrayObject{
	private int[] a = new int[30];
}