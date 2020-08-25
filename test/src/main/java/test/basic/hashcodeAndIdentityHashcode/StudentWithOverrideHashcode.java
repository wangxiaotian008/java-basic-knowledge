package test.basic.hashcodeAndIdentityHashcode;

public class StudentWithOverrideHashcode {

	private int id;
	
	private String name;
	
	public StudentWithOverrideHashcode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof StudentWithOverrideHashcode)) {
			return false;
		}
		
		StudentWithOverrideHashcode other = (StudentWithOverrideHashcode)obj;
		if (this.getId()!=other.getId() || !this.getName().equals(other.getName())) {
			return false;
		}
		
		return true;
	}
}
