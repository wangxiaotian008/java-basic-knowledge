package test.reflect;

import test.basic.parentAndChild.Child;

/**
 * 获取Class对象的方式三种
 * 当一个类被jvm加载之后，jvm通过调用类加载器中的defineClass 方法自动构造对应的这个类里的所有属性的Class对象，
 * 包括类， 属性， 构造函数，甚至基本数据类型。
 * 但是一个类只会有一个Class对象生成
 * @author Administrator
 *
 */
public class ClassObjectGenerate {

	public static void main(String[] args) {
		try {
			
			Child child = new Child();
			
			// 第一种：一般不会这样用，因为已经有了child对象了，还反射出class对象做什么。
			Class<? extends Child> childClass = child.getClass(); 
			Child childFromClass = (Child) childClass.newInstance();
			System.out.println(child == childFromClass); // 通过newInstance获取到的child对象是新的对象
			
			// 第二种: 需要导入相应的包，否则编译报错
			Class class1 = Child.class;
			System.out.println(childClass == class1); // 这两个class对象属于同一个class对象，都是jvm调用类加载器生成的
			
			
			Class classForName = Class.forName("test.parentAndChild.Child");
			System.out.println(childClass == classForName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
