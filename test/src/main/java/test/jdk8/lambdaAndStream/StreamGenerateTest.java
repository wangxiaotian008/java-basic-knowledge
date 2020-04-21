package test.jdk8.lambdaAndStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamGenerateTest {


	/**
	 * 创建stream
	 */
	@Test
	public void test0() {
		
		// 通过集合创建
		List<String> list = new ArrayList<String>();
		Stream<String> stream0 = list.stream();
		
		// 通过数组创建
		Employee[] employees = new Employee[10];
		Stream<Employee>stream1 = Arrays.stream(employees);
		
		// 通过Stream 的 of 方法
		Stream<String> stream2 = Stream.of(new String[] {"aa","bb"});
		stream1.forEach(System.out::println);
		
		// 通过Stream 的 iterate 迭代,  第一个参数是初始值，后面是运算过程。
		//运算过程: 
		// x = "a";
		// while(true){x = x + "ss"; System.out.println(x);}
//		UnaryOperator<String> unaryOperator = (x)-> x+"ss";
		Stream<String> stream3 = Stream.iterate("a", (x)-> x+"ss");
		stream3.limit(10).forEach(System.out::println); 
		
		// 通过Stream的generate
		Stream<Double> stream4 = Stream.generate(() -> Math.random());
		stream4.limit(10).forEach(System.out::println);
	}
}
