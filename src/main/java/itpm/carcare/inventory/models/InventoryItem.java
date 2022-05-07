package itpm.carcare.inventory.models;

public class InventoryItem {

	private int inventoryID;
	private String itemName;
	private double purchasedPrice;
	private int quantity;

	public InventoryItem() {
		super();
	}

	public InventoryItem(int inventoryID, String itemName, double purchasedPrice, int quantity) {
		super();
		this.inventoryID = inventoryID;
		this.itemName = itemName;
		this.purchasedPrice = purchasedPrice;
		this.quantity = quantity;
	}

	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPurchasedPrice() {
		return purchasedPrice;
	}

	public void setPurchasedPrice(double purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
