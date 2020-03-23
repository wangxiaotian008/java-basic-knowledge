package test.test;

import java.util.List;

public class Thread1 extends Thread {

	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Thread1(List<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("thread1"+list.get(i));
		}
	}
	
	
}
 