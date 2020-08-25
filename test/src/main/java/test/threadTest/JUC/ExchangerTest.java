package test.threadTest.JUC;

import java.util.concurrent.Exchanger;

/**
 * Exchanger 顾名思义交换，即交换两个线程里的值。exchange方法返回的是交换后的值
 * @author Administrator
 *
 */
public class ExchangerTest {

	public static void main(String[] args) {
		
		Exchanger<Student> exchanger = new Exchanger<Student>();
		
		Thread thread0 = new Thread(()->{
			Student student = new Student("stu0",10);
			try {
//				exchanger.exchange(student);
				System.out.println(Thread.currentThread().getName() + "-->" +exchanger.exchange(student));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread0");
		
		Thread thread1 = new Thread(()->{
			Student student = new Student("stu1",11);
			try {
				
				System.out.println(Thread.currentThread().getName() + "-->" +exchanger.exchange(student));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"thread1");
		
		thread0.start();
		thread1.start();
	}

}

class Student{
	private String name;
	
	private Integer age;

	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
