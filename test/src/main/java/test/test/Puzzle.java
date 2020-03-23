package test.test;

public class Puzzle {

	public final int value=4;
	
	public void doIt(){
		int value = 6;
		Runnable r = new Runnable() {
			public final int value = 5;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int value = 10;
				System.out.println(this instanceof Runnable);
				System.out.println(this.value);
			}
		};
		r.run();
	}
	public static void main(String[] args) {
		new Puzzle().doIt();
	}
}
