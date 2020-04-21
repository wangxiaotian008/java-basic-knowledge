package test.jdk8.lambdaAndStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamApiExerciseTest {

	
	/**
	 * test reduce
	 */
	@Test
	public void testReduce() {
		List<Integer> list = Arrays.asList(1,3,3,4,5,6,4);
		
		Optional<Integer> op = list.stream()
			.reduce((x, y) -> x + y);
		System.out.println(op.get());
	}
	
	/**
	 * 1. 给定一个数字列表，返回一个由每个数的平方组成的列表。 例： 【1,2,3,4,5】 返回 【1,4,9,16,25】
	 * 
	 */
	@Test
	public void test0() {
		List<Integer> list = Arrays.asList(1,3,3,4,5,6,4);
		System.out.println(generateSquare(list));
		
	}
	
	public List<Integer> generateSquare(List<Integer> list) {
		return list.stream()
					.map((e)->e * e)
					.collect(Collectors.toList());
					
	}
	
	List<Transaction> transactions = null;
	/**
	 * 用到 Trader 和 Transaction 的stream练习
	 */
	@Before
	public void before() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
	}
	
	
	/**
	 * 1.找出2011年发生的所有交易，并按交易额排序（高到低）
	 */
	@Test
	public void test1() {
		List<Transaction> list = transactions.stream()
					.filter(e -> e.getYear()==2011)
					.sorted((e1, e2) -> -Integer.compare(e1.getValue(), e2.getValue()))
					.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
	
	/**
	 * 2.交易员都在哪些不同的城市工作过
	 */
	@Test
	public void test2() {
		transactions.stream()
					.map((e) -> e.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);
	}
	
	
	/**
	 * 查找所有来自剑桥的交易员，并按名字排序
	 */
	@Test
	public void test3() {
		transactions.stream()
					.filter((e) -> e.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getTrader)
					.distinct()
					.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
					.forEach(System.out::println);
	}
	
	/**
	 * 返回所有交易员的姓名字符串，按字母顺序排序
	 */
	@Test
	public void test4() {
		transactions.stream()
					.map((e) -> e.getTrader().getName())
					.distinct()
					.sorted()
					.forEach(System.out::println);
		
		System.out.println("-------------");
//		BinaryOperator<T>
		Optional<String> contractName = transactions.stream()
					.map((e) -> e.getTrader().getName())
					.distinct()
					.sorted()
					.reduce((t1, t2) -> t1 + t2);
		
		System.out.println(contractName.get());
		
		System.out.println("--------------");
		
		transactions.stream()
				.map(e -> e.getTrader().getName())
				.flatMap(StreamApiExerciseTest::filterCharacter)
				.distinct()
				.sorted()
				.forEach(System.out::print);
	}
	
	public static Stream<String> filterCharacter(String name) {
		List<String> list = new ArrayList<String>();
		for(Character character : name.toCharArray()) {
			list.add(character.toString());
		}
		
		return list.stream();
	}
	
	/**
	 * 有没有交易员在米兰工作的
	 */
	@Test
	public void test5() {
		Boolean resultBoolean =transactions.stream()
											.anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
		System.out.println(resultBoolean);
	}
	
	/**
	 * 打印生活在剑桥的交易员的总交易额
	 */
	@Test
	public void test6() {
//		ToDoubleFunction<T>
		Optional<Integer> result = transactions.stream()
					.filter( (e) -> e.getTrader().getCity().equals("Cambridge"))
					.map((e)->e.getValue())
					.reduce(Integer::sum);
		System.out.println(result.get());
	}
	
	/**
	 * 找出所有交易额中最高的交易额
	 */
	@Test
	public void test7() {
		Optional<Integer> result = transactions.stream()
					.map(e -> e.getValue())
					.max(Integer::compareTo);
		
		System.out.println(result.get());
	}
	
	/**
	 * 找到交易额最小的交易
	 */
	@Test
	public void test8() {
		
		Optional<Transaction> result =transactions.stream()
					.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		
		System.out.println(result.get());
	}
}
