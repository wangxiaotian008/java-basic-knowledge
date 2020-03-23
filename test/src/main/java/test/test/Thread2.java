package test.test;

import java.util.List;

public class Thread2 extends Thread {

	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Thread2(List<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		list.add("mm");
	}
	
	
}
 