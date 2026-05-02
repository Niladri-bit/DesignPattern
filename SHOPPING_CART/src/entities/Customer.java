package entities;

public class Customer {
	private int customerId;
	private String name;
	private String emailId;
	public Customer(int customerId, String name, String emailId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
