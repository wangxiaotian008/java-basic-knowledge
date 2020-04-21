package test.jdk8.dateAndTime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class LocaleDateTimeTest {

	/**
	 * LocalDateTime 对时间做运算后会生成一个新的对象
	 */
	@Test
	public void test1() {
		// 生成实例
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		// 对日期进行计算 
		LocalDateTime ldt1=ldt.plusHours(1);
		System.out.println(ldt1);
	}
	
	/**
	 * 对时间格式化
	 */
	@Test
	public void test2() {
		LocalDateTime ldt = LocalDateTime.now();
		
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(dFormatter.format(ldt));
	}
	
	/**
	 * 时间戳
	 */
	@Test
	public void test3() {
		Instant instant = Instant.now(); // 这个获取到的是UTC时间
		
		System.out.println(instant);
		
		// 获取
		Instant instant2 = Instant.now();
		
		OffsetDateTime dateTime = instant2.atOffset(ZoneOffset.ofHours(8));// 时区偏移量，中国时区是UTC+8
		System.out.println(dateTime);
	}
	
	/**
	 * Duration 计算两个时间之间的时间间隔
	 * Period 计算两个日期之间的日期间隔
	 * @throws InterruptedException 
	 */
	@Test
	public void test4() throws InterruptedException {
		LocalDateTime ldt = LocalDateTime.now();
		Thread.sleep(5000);
		
		LocalDateTime ldt1=LocalDateTime.now();
		Duration duration = Duration.between(ldt, ldt1);
		
		System.out.println(duration.toMillis());
		System.out.println(duration.toNanos());
		
		LocalDate date = LocalDate.now();
		LocalDate date1 = date.plusDays(1);
		Period period = Period.between(date, date1);
		System.out.println(period.getDays());
		
	}
	
	/**
	 * 时间矫正器 ,TemporalAdjuster(函数式接口),对应的工具类是TemporalAdjusters
	 */
	@Test
	public void test5() {
		LocalDateTime ldt = LocalDateTime.now();
		
		LocalDateTime ldt1 = ldt.withDayOfMonth(10); // 这样就能指定为当前时间的10号
		System.out.println(ldt1);
		
		// TemporalAdjuster
		LocalDateTime ldt2 = ldt.with(TemporalAdjusters.firstDayOfYear());
		System.out.println(ldt2);
		
		// 还可以自定义，返回下一个工作日的日期
		LocalDateTime ldt4 = ldt.with((l) -> {
			LocalDateTime ldt3 = (LocalDateTime)l;
			
			if(ldt3.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
				return ldt3.plusDays(3);
			}else if(ldt3.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
				return ldt3.plusDays(2);
			}else {
				return ldt3.plusDays(1);
			}
		});
		System.out.println(ldt4);
	}
	
	/**
	 * ZoneId, ZoneOffset, ZonedDateTime
	 */
	@Test
	public void test6() {
		
		// 获取所有时区
		System.out.println(ZoneId.getAvailableZoneIds());
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldt);
		
		ZonedDateTime zDateTime = ZonedDateTime.now(); //结果：2020-04-17T18:45:32.227+08:00[Asia/Shanghai]
		System.out.println(zDateTime);
	}
}
