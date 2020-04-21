package test.threadTest.threadExercise;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TwoThreadPrintNum {

	private int num;
	
	public TwoThreadPrintNum(int num) {
		super();
		this.num = num;
	}

	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 两个线程交替打印1~100， A线程打印奇数，B线程打印偶数
	 */
	public static void main(String[] args) {
		Object object = new Object();
		TwoThreadPrintNum nPrintNum = new TwoThreadPrintNum(0);
		Thread threadA = new Thread(() ->{
			
			System.out.println("A start");
			synchronized (object) {
				while (nPrintNum.getNum() <= 100) {
					
					if(nPrintNum.getNum()%2 !=0) {
						System.out.println("线程A：" + nPrintNum.getNum());
						nPrintNum.setNum(nPrintNum.getNum()+1);
						object.notify();
					}else {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		
		Thread threadB = new Thread(() ->{
			
			System.out.println("B start");
			synchronized (object) {
				while (nPrintNum.getNum() <=100) {
					
					if(nPrintNum.getNum()%2 ==0) {
						System.out.println("线程B：" + nPrintNum.getNum());
						nPrintNum.setNum(nPrintNum.getNum()+1);
						object.notify();
					}else {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		threadA.start();
		threadB.start();
	}
}
