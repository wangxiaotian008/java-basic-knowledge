package test.threadTest.JUC.interviewQuestion;

import java.util.ArrayList;
import java.util.List;

public class MycollectionForQuestion1 {
	
	List<Object> list = new ArrayList<>();
	
	public void add(Object object) {
		list.add(object);
	}
	
	public int getSize() {
		return list.size();
	}
}