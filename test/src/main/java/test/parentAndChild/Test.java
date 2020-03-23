package test.parentAndChild;

public class Test {

	public static void main(String[] args) {
		
		Parent parent = new Parent("aa", 12);
		Child child = new Child("bb", 10);
		System.out.println(child.getParentName());
		
		child.setParentName("cc");
		
		System.out.println(child.getChildName());
		System.out.println(child.getParentName());
		System.out.println(parent.getParentAge());
		
		StringBuilder builder = new StringBuilder("1");
		
		builder.append("12345678901234567890");

	}

}
