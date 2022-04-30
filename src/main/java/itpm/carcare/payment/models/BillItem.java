package itpm.carcare.payment.models;

public class BillItem {

	private int userID;
	private int serviceID;

	public BillItem() {
		super();
	}

	public BillItem(int userID, int serviceID) {
		super();
		this.userID = userID;
		this.serviceID = serviceID;
	}

	public int getBillItemID() {
		return userID;
	}

	public void setBillItemID(int userID) {
		this.userID = userID;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

}
