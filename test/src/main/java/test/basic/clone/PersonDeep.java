package test.basic.clone;

public class PersonDeep implements Cloneable {

	 public String pname;
	    public int page;
	    public AddressDeep address;
	    public PersonDeep() {}
	    
	    public PersonDeep(String pname,int page){
	        this.pname = pname;
	        this.page = page;
	        this.address = new AddressDeep();
	    }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	    	PersonDeep personDeep =(PersonDeep)super.clone();
	    	personDeep.address = (AddressDeep) address.clone();
	        return personDeep;
	    }
	    
	    public void setAddressDeep(String provices,String city ){
	        address.setAddressDeep(provices, city);
	    }
	    public void display(String name){
	        System.out.println(name+":"+"pname=" + pname + ", page=" + page +","+ address);
	    }

	    public String getPname() {
	        return pname;
	    }

	    public void setPname(String pname) {
	        this.pname = pname;
	    }

	    public int getPage() {
	        return page;
	    }

	    public void setPage(int page) {
	        this.page = page;
	    }
}
