package states;

import atmMachine.ATM;
import entities.Card;
import enumerations.TransitionType;

public class IdleState implements ATMState{

	@Override
	public void insertCard(ATM atm, String cardNumber) {
		Card card = atm.getBankService().authenticate(cardNumber);
		if(card==null) {eject(atm);}else {
		atm.setCurrentCard(card);
		atm.changeState(new HasCardState());
		System.out.println("Card inserted successfully. Card Number:- "+cardNumber);
		}
	}

	@Override
	public void authenticate(ATM atm, String pin) {
		System.out.println("Please insert the card");
		
	}

	@Override
	public void selectOperation(ATM atm, TransitionType transitionType, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Please insert the card");
	}

	@Override
	public void eject(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("Card has been ejected");
		atm.setCurrentCard(null);
	}

}
