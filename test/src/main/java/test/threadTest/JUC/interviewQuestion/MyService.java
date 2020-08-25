package test.threadTest.JUC.interviewQuestion;
public class MyService
	{
	    private int flag = 1;
	    
	    public synchronized void printA(){
	        
	        while (flag != 1)
	        {
	            try
	            {
	                this.wait();
	            }
	            catch (InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        System.out.print(Thread.currentThread().getName());
	        flag = 2;
	        this.notifyAll();
	    }
	    public synchronized void printB(){
	        while (flag != 2)
	        {
	            try
	            {
	                this.wait();
	            }
	            catch (InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        System.out.print(Thread.currentThread().getName());
	        flag = 3;
	        this.notifyAll();
	    }
	    public synchronized void printC(){
	        while (flag != 3)
	        {
	            try
	            {
	                this.wait();
	            }
	            catch (InterruptedException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        System.out.print(Thread.currentThread().getName());
	        flag = 1;
	        this.notifyAll();
	    }
	}
	