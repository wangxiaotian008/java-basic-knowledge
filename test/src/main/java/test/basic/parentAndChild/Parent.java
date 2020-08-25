package test.basic.parentAndChild;

public class Parent {

	private String parentName;
	
	private int parentAge;

	public Parent() {
		super();
	}

	public Parent(String parentName, int parentAge) {
		this.parentName = parentName;
		this.parentAge = parentAge;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public int getParentAge() {
		return parentAge;
	}

	public void setParentAge(int parentAge) {
		this.parentAge = parentAge;
	}
	
	public void test() {
		System.out.println("parent test");
	}
}
