package test.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {


	public void i(final Demo demo){
		demo.i++;
	}
	private final int temp = 0;
	public static void main(String[] args) throws UnsupportedEncodingException {
//		new Test().i(new Demo());
//		Integer i =128;
//		List<String> list = new ArrayList<String>();
//		List list = new ArrayList();
//		list.add("a");
//		Iterator<String> iterator = list.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//			list.add("mm");
//		}
//		String s = "s";
//		int yichu = Integer.MAX_VALUE + 8;
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE+1);
//		System.out.println(Integer.MAX_VALUE+2);
//		System.out.println(yichu);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//			list.remove(i);
//		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
////			list.remove(i);
//		}
//		Thread1 thread1 = new Thread1(list);
//		Thread2 thread2 = new Thread2(list);
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		executorService.execute(thread1);
//		executorService.execute(thread2);
//		executorService.execute(thread2);
//		executorService.execute(thread2);
//		executorService.execute(thread2);
//		executorService.execute(thread1);
//		executorService.execute(thread2);
//		executorService.execute(thread1);
//		executorService.execute(thread2);
		
//		final int count = 10;
//		final Runnable thread1 = new Runnable() {
//			
//			public void run() {
//				for (int j = 0; j < 100; j++) {
//					if(j == count){
//						try {
//							Thread.currentThread().sleep(5000);
//						} catch (InterruptedException e) {
//							if(!Thread.currentThread().isInterrupted()){
//								System.out.println("interrupted is true");
//							}
//							System.out.println("阻塞的线程被中止");
//							System.out.println(Thread.currentThread().isAlive());
//							e.printStackTrace();
//						}
//					}
//				}
//				
//			}
//		};
//		final Thread test1 = new Thread(thread1);
//		Runnable thread2 = new Runnable() {
//			
//			public void run() {
//				for (int j = 0; j < 100; j++) {
//					if(j == count){
//						test1.interrupt();
//					}
//				}
//				
//			}
//		};
//		Thread test2 = new Thread(thread2);
//		test1.start();
//		test2.start();
//		short b = 2;
//		int a = 3;
//		System.out.println(b=(short) (a+b));
//		System.out.println(b+=a);
//		ArrayList<String> list = new ArrayList<String>(50);
//		list.add("1");
//		list.add("2");
//		list.add(1, "11111");
//		System.out.println(list.size());
//		for (int j = 0; j < list.size(); j++) {
//			String string = list.get(j);
////			System.out.println(string);
//			
//		}
//		String s  = new String(" ");//("中文");
//		System.out.println(s.getBytes("utf-8").length);
//		byte[] b = s.getBytes("utf-8");
//		for (int j = 0; j < b.length; j++) {
//			System.out.println(Integer.toHexString(0xff&b[j]));
//		}
//		
//		System.out.println( new String(new byte[]{0x01}));
//		
////		System.out.println(System.getProperties().list(System.out););
//		System.getProperties().list(System.out);
//		int temp = 9;
//		System.out.println(new Test().test());
	}
	public int test(){
		int temp = 9;
		return temp;
	}

}
