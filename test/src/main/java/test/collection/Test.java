package test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	public static void main(String[] args) {
//		int h= "hello".hashCode();
//		int m = h >>> 16;
//		int hash = h ^ m;
//		System.out.println(Integer.toBinaryString(h).length());
//		System.out.println(Integer.toBinaryString(h));
//		System.out.println(Integer.toBinaryString(m));
//		System.out.println(Integer.toBinaryString(hash));
//		List<Integer> list = new ArrayList<Integer>();
//		
//		list.add(0);
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		RandomAccess randomAccess;
//		
//		LinkedList<Integer> linkedList;
//		
//		HashSet<Integer> hashSet;
//		
		HashMap<String, String> hashMap = new HashMap<String, String>();
//		
//		for (int i = 0; i < 17; i++) {
//			if (i==14) {
//				System.out.println("sss");
//			}
//			hashMap.put("a"+i, "aa"+i);
//		}
//		
//		System.out.println(tableSizeFor(13));
		
		ConcurrentHashMap map;
		
		
	}
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
}
