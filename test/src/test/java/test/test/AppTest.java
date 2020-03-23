package test.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public static void main(String[] args) {
		String s = new String("ss");
		char[] a = s.toCharArray();
		int i = a.length;
		s.length();
		char[] c1 = {'a','b','c'};
		char[] c2 = c1;
		c1[1] = 'x';
//		Map m = new HashMap<>();
		List list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		System.out.println(list.toArray().length);
		List list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		list1.add("e1");
		list1.add("e");
		list1.add("e2");
		list1.add("e3");
		list1.add("e");
//		list.addAll(list1);
		list1.remove("e");
		System.out.println(list1);
//		System.out.println(list.size());
//		System.out.println(c2);
//		System.out.println(s);
//		String[] a1 = {"a","b","c","d","e",null,null,null,null,null};
//		String[] b1 = {"a","b","c","d","e"};
//		String[] d1 =  new String[15];
//		System.arraycopy(a1, 0, d1, 0, Math.min(10, 15));
//		System.out.println(d1);
		Vector v = new Vector<String>();
		System.out.println(7 >> 1);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("a", "1");
		
		String ss = "ss";
		System.out.println(ss.hashCode());
		
		String aa = new String("ss");
		System.out.println(aa.hashCode());
		Integer i1 = -20;
		Integer i2 = 9;
		System.out.println(Integer.toBinaryString(i1));
		System.out.println(Integer.toBinaryString(i2));
		System.out.println("222" + (i1 >> 2));
		System.out.println(i2 >> 1);
		
		System.out.println("异或运算");
		int[] array = {2,3,4,4,3,5,7,6,6,5,2};
		int v1 = 0;
		for (int i11 = 0;i11 < array.length;i11++) {
			v1 ^= array[i11];
			System.out.println(v1);
		}
//		System.out.println(0^2);
		int m = 10;
		int n = 11;
		m = m^n;
		n = n^m;
		m = m^n;
		System.out.println("m" + m + "n" + n);
		Integer i127 = 127;
		System.out.println("127的二进制" + Integer.toBinaryString(i127));
		
	}
}
