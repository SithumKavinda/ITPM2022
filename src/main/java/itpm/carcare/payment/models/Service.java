package itpm.carcare.payment.models;

public class Service {
	private int serviceID;
	private String serviceName;
	private double discount;
	private double price;

	public Service() {
		super();
	}

	public Service(int serviceID, String serviceName, double discount, double price) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.discount = discount;
		this.price = price;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
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
