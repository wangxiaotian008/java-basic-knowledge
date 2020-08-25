//package test.collection;
//
//import java.util.concurrent.DelayQueue;
//import java.util.concurrent.Delayed;
//import java.util.concurrent.TimeUnit;
//
//public class DelayQueueTest {
//
//	public static void main(String[] args) {
//		DelayQueue<Mydelayed> delayQueue = new DelayQueue<Mydelayed>();
//		
//		
//		
//
//	}
//
//}
//
//class Mydelayed implements Delayed{
//
//	private String name;
//	private long runningTime;
//	
//	public Mydelayed(String name, long runningTime) {
//		super();
//		this.name = name;
//		this.runningTime = runningTime;
//	}
//
//	@Override
//	public int compareTo(Delayed o) {
//		// TODO Auto-generated method stub
//		Mydelayed other = (Mydelayed)o;
//		return this.remainTime - other.remainTime<=0?-1:1;
//	}
//
//	@Override
//	public long getDelay(TimeUnit unit) {
//		// TODO Auto-generated method stub
//		unit.co
//		return unit-System.currentTimeMillis();
//	}
//	
//}
