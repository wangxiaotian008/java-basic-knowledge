package test.lamdba;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TestLamdbaComparator {

	public static void overrideComparatorSort(List<User> list){
		Collections.sort(list, new Comparator<User>() {
			
			public int compare(User o1, User o2) {
				if(o1.getAge() > o2.getAge()){
					return 1;
				}else if(o1.getAge() < o2.getAge()){
					return -1;
				}
				return 0;
			}
		});
	}
	
	public static void lamdbaComparatorSortInteger(List<Integer> list){
//		Comparator c = (User u1,User u2) -> if(u1.getAge() > u2.getAge())  
		Collections.sort(list, (Integer u1,Integer u2) -> {if(u1 > u2)return -1;if(u1 < u2) return 1; return 0;});
		
	}
	public static void lamdbaComparatorSortUser(List<User> list){
//		Comparator c = (User u1,User u2) -> if(u1.getAge() > u2.getAge())  
		Collections.sort(list, (User u1,User u2) -> {if(u1.getAge() > u2.getAge())return 1;if(u1.getAge() < u2.getAge()) return -1; return 0;});
		
	}
	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		List<Integer> list1 = new ArrayList<Integer>();
		list.add(new User(10, "a"));
		list.add(new User(20, "b"));
		list.add(new User(5, "c"));
		list.add(new User(15, "d"));
		list1.add(new Integer(12));
		list1.add(new Integer(11));
		list1.add(new Integer(4));
		list1.add(new Integer(17));
//		Test.overrideComparatorSort(list);
//		Test.lamdbaComparatorSortInteger(list1);
		TestLamdbaComparator.lamdbaComparatorSortUser(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
