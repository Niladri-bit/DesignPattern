package entities;

public class Split {
	private final String userId;
	private double amount;
	
	public Split(String userId) {
		this.userId=userId;
		this.amount = 0.0;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUserId() {
		return userId;
	}
	
	
}
