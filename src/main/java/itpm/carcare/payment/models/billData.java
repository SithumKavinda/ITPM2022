package itpm.carcare.payment.models;

public class billData {
	
	private int billNo;
	private String serviceName;
	private double discount;
	private double price;
	
	public billData() {
		super();
	}
	
	public billData(int billNo, String serviceName, double discount, double price) {
		super();
		this.billNo = billNo;
		this.serviceName = serviceName;
		this.discount = discount;
		this.price = price;
	}

	public billData(String serviceName, double discount, double price) {
		super();
		this.serviceName = serviceName;
		this.discount = discount;
		this.price = price;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
		
	
}
