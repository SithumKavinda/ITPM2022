package itpm.carcare.payment.models;

public class billData {
	
	int billNo;
	int serviceNo;
	String serviceName;
	double discount;
	double total;
	double subTotal;
	
	public billData() {
		super();
	}

	public billData(int billNo, int serviceNo, String serviceName, double discount, double total, double subTotal) {
		super();
		this.billNo = billNo;
		this.serviceNo = serviceNo;
		this.serviceName = serviceName;
		this.discount = discount;
		this.total = total;
		this.subTotal = subTotal;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
