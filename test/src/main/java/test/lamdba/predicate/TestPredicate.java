package test.lamdba.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {

	public static void filter(List<String> names, Predicate condition){
		for(String name : names){
			if(condition.test(name)){
				System.out.println(name + " ");
			}
		}
	}
	public static void main(String[] args) {
		List<String> languages = Arrays.asList("java","Scale","C++","Haskell","Lisp");
		filter(languages,(str)->((String) str).startsWith("ja"));
		filter(languages,(str)->((String) str).length()>4);
		String s1 = "s";//new String("s");
		String s2 = "s";//new String("s");
		System.out.println(s1 == s2);
	}
}
