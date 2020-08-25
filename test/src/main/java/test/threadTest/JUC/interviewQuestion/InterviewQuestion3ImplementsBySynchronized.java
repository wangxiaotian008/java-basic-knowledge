package test.threadTest.JUC.interviewQuestion;

import java.util.concurrent.CountDownLatch;

/**
 * 如果是多个线程，用if来判断的话，可能会造成虚假唤醒的器·问题。（虚假唤醒只是一个表象，jkd里已经有注释说如果用了wait就该用while循环）
 * @author Administrator
 *
 */
public class InterviewQuestion3ImplementsBySynchronized {
	static int flag = 0;

	public static void main(String[] args) throws InterruptedException {
		
		Object object = new Object();
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		new Thread(()->{
			
			synchronized (object) {
				for (int i = 0; i < 10; i++) {
					while (flag != 0) {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + "===> A");
					flag = 1;
					object.notifyAll();
				}
			}
			
		},"A").start();
		
		new Thread(()->{
			synchronized (object) {
				for (int i = 0; i < 10; i++) {
					while (flag != 1) {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + "===> B");
					flag = 2;
					object.notifyAll();
				}
			}	
					
		},"B").start();
		
		new Thread(()->{
			
			synchronized (object) {
				for (int i = 0; i < 10; i++) {
					while (flag != 2) {
						try {
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + "===> C");
					flag = 0;
					object.notifyAll();
				}
			}
			countDownLatch.countDown();
			
		},"C").start();
		
		countDownLatch.await();
	}
	
	static void test() {
		MyService service = new MyService();
//        MyService2 service = new MyService2();
        
        Thread A = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printA();
                }
            }
        });
        A.setName("A");
        Thread B = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printB();
                }
            }
        });
        B.setName("B");
        Thread C = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 5; i++)
                {
                    service.printC();
                }
            }
        });
        C.setName("C");
        
        A.start();
        B.start();
        C.start();
	}
 

	
	
	
	

}
