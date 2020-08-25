package test.basic.clone;

import java.util.ArrayList;
import java.util.List;

/**
 * 深拷贝和浅拷贝
 * 1、浅拷贝：创建一个新对象，如果把当前对象的非静态字段复制到新对象，如果是值类型，则直接复制，如果是引用类型则，则是复制引用而非对象，即引用也指向同一个对象。
 * 2、深拷贝: 创建一个新对象，无论是值类型还是引用类型，都是复制新的独立一份。
 * 		实现方法：① 既然引用类型不能深拷贝，那么就把引用类型拆分为基本数据类型进行浅拷贝。
 * 				 ② 使用序列化，反序列化来生成
 * @author Administrator
 *
 */
public class DeepCopyAndShallowCopyTest {

	public static void main(String[] args) {
		Person p1 = new Person("zhangsan",21);
	    p1.setAddress("湖北省", "武汉市");
	    Person p2 = null;
		try {
			p2 = (Person) p1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("p1:"+p1);
	    System.out.println("p1.getPname:"+p1.getPname().hashCode());
	    
	    System.out.println("p2:"+p2);
	    System.out.println("p2.getPname:"+p2.getPname().hashCode());
	    
	    System.out.println("p1和p2的address");
	    System.out.println("p1.address" + p1.address.hashCode());
	    System.out.println("p2.address" + p2.address.hashCode());
	    p1.display("p1");
	    p2.display("p2");
	     // 浅拷贝，p1和p2的address指向同一个对象
	    p2.setAddress("湖北省", "荆州市");
	    System.out.println("将复制之后的对象地址修改：");
	    p1.display("p1");
	    p2.display("p2");
	    
	    
	    System.out.println("深拷贝实现======");
	    // 深拷贝
	    PersonDeep p1deep = new PersonDeep("zhangsan",21);
	    p1deep.setAddressDeep("湖北省", "武汉市");
	    PersonDeep p2deep = null;
		try {
			p2deep = (PersonDeep) p1deep.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("p1deep:"+p1deep);
	    System.out.println("p1deep.getPname:"+p1deep.getPname().hashCode());
	    
	    System.out.println("p2deep:"+p2deep);
	    System.out.println("p2deep.getPname:"+p2deep.getPname().hashCode());
	    
	    // 深拷贝， address的地址不一样
	    System.out.println("p1deep和p2deep的address");
	    System.out.println("p1deep.address" + p1deep.address.hashCode());
	    System.out.println("p2deep.address" + p2deep.address.hashCode());
	    p1deep.display("p1deep");
	    p2deep.display("p2deep");
	    p2deep.setAddressDeep("湖北省", "荆州市");
	    System.out.println("将复制之后的对象地址修改：");
	    p1deep.display("p1deep");
	    p2deep.display("p2deep");
	    
	}

}
