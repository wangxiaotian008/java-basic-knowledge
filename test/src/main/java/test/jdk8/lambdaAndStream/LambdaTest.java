package test.jdk8.lambdaAndStream;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

/**
 * Lambda 需要函数式接口（只有一个抽象方法的接口，可以加@FunctionalInterface来检查接口是不是函数是接口）的支持，
 * @author Administrator
 *
 */
public class LambdaTest {
	
	@Test
	public void test0() {
		MyLamdbaInfterface name = (x)-> x.toUpperCase().substring(1, 3);
		System.out.println(upperStr("abcdef", name));
	}
	
	public String upperStr(String value, MyLamdbaInfterface myLamdbaInfterface) {
		return myLamdbaInfterface.getValue(value);
	}
	
	/**
	 * jdk8 已经提供了一些函数式接口类,
	 * Consumer, Supplier, Function,Predicate
	 */
	@Test
	public void test1() {
		Consumer<Integer>  consumer = (x) -> System.out.println(Math.random() + x);
		consumer.accept(10);
		
		Employee employee = new Employee(10, "jakcy", 20);
		Supplier<String> supplier = ()-> employee.getName();
		
		System.out.println(supplier.get());
		
		
		Function<Integer, Integer> function = (x) -> employee.getAge() + x;
		System.out.println(function.apply(10));
		
		Predicate<String> predicate = (x) -> x.equals("ss");
		System.out.println(predicate.test("sss"));
	}
	
	/**
	 * 用方法引用来替代lambda表达式
	 * tips: lambda 体中的调用方法的参数列表和返回类型要和函数式接口中的函数的参数列表和返回值一致。
	 * 		 类：：实例方法名， 如果参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用  类::实例方法名
	 */
	@Test
	public void test2() {
		Employee employee = new Employee(10, "jakcy", 20);
		
		// 对象 :: 实例方法名
		Supplier<String> supplier1 = employee::getName;
		System.out.println(supplier1.get());
		
		// 类::静态方法名
		Comparator<Integer> comparator = Integer::compare;
		System.out.println(comparator.compare(12, 12));
		
		// 类:: 实例方法名
		BiPredicate<String, String> biPredicate = String::equals;
		System.out.println(biPredicate.test("ss", "sss"));
		
	}
}
