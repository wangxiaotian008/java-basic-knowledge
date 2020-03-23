package test.stringTest;

import java.lang.reflect.Field;

/**
 * 一般情况下String是不可变的，是因为他的实现是一个final修饰的char数组。
 * 但是可以通过反射来改变他的值。
 * @author Administrator
 *
 */
public class StringValueChangeByReflect {

	public static void main(String[] args) {
		String ss = "hello world";
		
		try {
			Field field = String.class.getDeclaredField("value");
			
			field.setAccessible(true);
			
			char[] value =(char[]) field.get(ss);
			
			value[5] = '_';
			
			System.out.println(ss);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
