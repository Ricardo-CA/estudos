package model.enums;

public enum statusOrder {
	PENDING_PAYMENT(0),
	PROCESSING(1),
	SHIPPED (2),
	DELIVERED(3);
	
	private int number;
	
	 statusOrder(int number) {
	       this.number = number;
	    }

	    public int getNumber() {
	        return number;
	    }

}
