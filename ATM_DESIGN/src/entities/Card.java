package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Card {

	private final String cardNumber;
	private final String pin;
	
	public Card(String cardNumber,String pin) {
		this.pin=pin;
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getPin() {
		return pin;
	}
}
