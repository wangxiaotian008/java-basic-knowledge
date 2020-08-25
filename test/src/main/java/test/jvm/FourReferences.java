package test.jvm;

import java.lang.ref.WeakReference;

public class FourReferences {

	
	public static void main(String[] args) {
		weakRefrenceTest();
	}
	
	public static void weakRefrenceTest() {
		WeakReference<Myrefrence> weakReference = new WeakReference<Myrefrence>(new Myrefrence("weak"));
		
		System.gc();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(weakReference.get());
		System.out.println("weak test end");
	}
}

class Myrefrence{
	
	private String name;

	public Myrefrence(String name) {
		super();
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("被回收了");
	}

	@Override
	public String toString() {
		return "Myrefrence [name=" + name + "]";
	}
	
}
