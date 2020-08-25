package test.basic.enumTest;
public class Pizza {
    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED{

			@Override
			public void test() {
				// TODO Auto-generated method stub
				super.test();
			}
        	
        },
        READY,
        DELIVERED;
    	
    	public void test() {
		}
    }
 
    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }

	public PizzaStatus getStatus() {
		return status;
	}

	public void setStatus(PizzaStatus status) {
		this.status = status;
	}
}