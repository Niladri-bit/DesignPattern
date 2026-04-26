package enumerations;

public enum Denomination {
	TEN(10),
	TWENTY(20),
	FIFTY(50),
	HUNDRED(100),
	TWO_HUNDRED(200),
	FIVE_HUNDRED(500);
	
	private int amount;

	Denomination(int i) {
		this.amount = i;
	}
	
}
