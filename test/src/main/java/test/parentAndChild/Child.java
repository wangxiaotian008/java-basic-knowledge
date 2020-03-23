package test.parentAndChild;

public class Child extends Parent{

	

	private String childName;
	
	private int childAge;
	
	public Child(String parentName, int parentAge) {
//		super(parentName, parentAge);
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public int getChildAge() {
		return childAge;
	}

	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}

}
