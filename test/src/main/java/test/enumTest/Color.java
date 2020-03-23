package test.enumTest;

public enum Color {

	RED("红",1),GREEN("绿",2),YELLOW("黄",3);
	
	private String name;
	private int index;
	private Color(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + "_" + this.index;
	}

	
}
