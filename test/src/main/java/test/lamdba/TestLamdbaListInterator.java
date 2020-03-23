package test.lamdba;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestLamdbaListInterator {

	/**
	 * jdk8之前遍历集合
	 * @param list
	 */
	public void listInteratorBeforeJDK8(List<String> list){
		for(String s : list){
			System.out.println(s);
		}
	}
	/**
	 * jdk8之后遍历集合
	 * @param list
	 */
	public void listInteratorAfterJDK8(List<String> list){
		list.forEach(temp->System.out.println(temp));
	}
	/**
	 * jdk8之后使用lamdba遍历集合,使用java8的方法引用更方便，方法引用由::双冒号操作符标示。
	 * @param list
	 */
	public void listInteratorAfterJDK8ByLamdba(List<String> list){
		list.forEach(System.out::println);
	}
	
	/**
	 * jdk8之前遍历集合  Map
	 * @param map
	 */
	public void mapInteratorBeforeJDK8(Map<String,Object> map){
		// 大数据遍历速度快
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + "value=" + entry.getValue() );
		}
	}
	/**
	 * jdk8之后遍历集合
	 * @param list
	 */
	public void mapInteratorAfterJDK8(Map<String,Object> map){
		map.forEach((k,v)->System.out.println(k + v));
	}
	
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Lambdas","Default Method","Stream Api","Date and Time API");
		TestLamdbaListInterator test = new TestLamdbaListInterator();
		System.out.println("jdk8前");
		test.listInteratorBeforeJDK8(list);
		System.out.println("jdk8后");
		test.listInteratorAfterJDK8(list);
		System.out.println("jdk8后lambda");
		test.listInteratorAfterJDK8ByLamdba(list);
	}

}
