package entities;

public class PercentageSplit extends Split{
	private final double percentage;
	public PercentageSplit(String userId,double percentage) {
		super(userId);
		this.percentage = percentage;
		// TODO Auto-generated constructor stub
	}
	public double getPercentage() {
		return percentage;
	}

	
}
