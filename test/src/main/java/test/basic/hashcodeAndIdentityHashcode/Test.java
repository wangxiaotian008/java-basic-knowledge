package test.basic.hashcodeAndIdentityHashcode;

/**
 * 一个对象的hashCode和identityHashCode 的关系：
 * 1：对象的hashCode，一般是通过将该对象的内部地址转换成一个整数来实现的
 * 2：当一个类没有重写Object类的hashCode()方法时，它的hashCode和identityHashCode是一致的
 * 3：当一个类重写了Object类的hashCode()方法时，它的hashCode则有重写的实现逻辑决定，此时的hashCode值一般就不再和对象本身的内部地址有相应的哈希关系了
 * 4：当null调用hashCode方法时，会抛出空指针异常，但是调用System.identityHashCode(null)方法时能正常的返回0这个值
 * 5：一个对象的identityHashCode能够始终和该对象的内部地址有一个相对应的关系，从这个角度来讲，它可以用于代表对象的引用地址，所以，在理解==这个操作运算符的时候是比较有用的
 *
 */
public class Test {

	public static void main(String[] args) {
		//基本数据类型的测试数据
         byte _byte = 6;
         byte _byte1 = 6;
         char _char = 's';
         short _short = 6;
         int _int = 6;
         long _long = 6L;
         float _float = 6;
         double _double= 6;
         boolean _boolean = true;

        //包装类型的测试数据
         Byte _Byte = 9;
         Character _Character = 'S';
         Short _Short = 9;
         Integer _Integer = 9;
         Long _Long = 9L;
         Float _Float = 9F;
         Double _Double = 9D;
         Boolean _Boolean = false;
         
         String ssNoNew = "some";
         
         String ssNoNew0 = "some"; //因为上面出现过一次，所以这个变量的值是从常量池里拿的
         
         Student student0 = new Student(1,"tom");// 没有重写hashcode方法，hashcode 和identityhashcode返回值一样
         StudentWithOverrideHashcode student1 = new StudentWithOverrideHashcode(1,"tom");//
         
       //基本数据类型的测试数据
         System.out.println("\n测试基本数据类型的数据");
         printHashCodes(_byte);
         printHashCodes(_byte1);
         printHashCodes(_char);
         printHashCodes(_short);
         printHashCodes(_int);
         printHashCodes(_long);
         printHashCodes(_float);
         printHashCodes(_double);
         printHashCodes(_boolean);

         //包装类型的测试数据
         System.out.println("\n测试包装数据类型的数据");
         printHashCodes(_Byte);
         printHashCodes(_Character);
         printHashCodes(_Short);
         printHashCodes(_Integer);
         printHashCodes(_Long);
         printHashCodes(_Float);
         printHashCodes(_Double);
         printHashCodes(_Boolean);
         
         System.out.println("String 类型");
         printHashCodes(ssNoNew);
         printHashCodes(ssNoNew0);
         
         System.out.println("引用类型");
         printHashCodes(student0);
         printHashCodes(student1);
	}
	
	/**
     * 输出对象重写的hashCode和唯一的hashCode
     * @param object
     */
    public static void printHashCodes( Object object)
    {
        //输入对象的数据类型，以及调用toString()方法后返回的字符串形式，当对象为空时，此处输出null
        System.out.println("\nThe object type is  : " + (object != null ? object.getClass().getName() : "null") + "\nThe object value is : "+String.valueOf(object));
        //输出对象的hashCode值，当对象为空时，此处输出N/A
        System.out.println("Overridden hashCode : " + (object != null ? object.hashCode() : "N/A"));
        //输出对象的identityHashCode值，如果对应的类没有重写Object类的hashCode()方法，则和默认的hashCode值一致
        System.out.println("Identity   hashCode : " + System.identityHashCode(object));
    }

	
}
