package test.jvm;

/**
 * 演示目的：
 * 1。对象可以在gc时完成自我拯救
 * 2。这种自救只能执行一次，因为一个对象的finalize方法只会被调用一次
 * @author Administrator
 *
 */
public class FinalizeEscapseGC {

	public static FinalizeEscapseGC SAVE_HOOK=null;
	public void isAlive() {
		System.out.println("yes, I am still alive");
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize method excuted");
		SAVE_HOOK = this;
	}


	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapseGC();
		// 对象第一次自救
		SAVE_HOOK = null;
		System.gc();
		
		
		Thread.sleep(1000); // 因为finalize方法优先级特别低，所以要睡1秒
		
		if(SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("instance died");
		}
		
		// 第二次再执行就不会自救了，因为finalize方法只会被执行一次
		SAVE_HOOK = null;
		System.gc();
		
		Thread.sleep(1000);
		
		if(SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("instance died");
		}
		

	}

}
