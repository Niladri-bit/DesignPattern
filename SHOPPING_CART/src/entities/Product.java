package entities;

import enumerations.ProductCategory;

public class Product {
	private int productId;
	private String productName;
	private int maxQuantity;
	private float price;
	private ProductCategory category;
	public Product(int productId, String productName, int maxQuantity, float price, ProductCategory category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.maxQuantity = maxQuantity;
		this.price = price;
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	
}
