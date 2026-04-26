package states;

import atmMachine.ATM;
import entities.Card;
import enumerations.TransitionType;

public class HasCardState implements ATMState{

	@Override
	public void insertCard(ATM atm, String cardNumber) {
		// TODO Auto-generated method stub
		System.out.println("A card is already inserted");
		
	}

	@Override
	public void authenticate(ATM atm, String pin) {
		// TODO Auto-generated method stub
		System.out.println("Authenticating pin");
		Card card =atm.getCurrentCard();
		 if(!atm.getBankService().authenticate(card.getCardNumber(), pin)) {
			 eject(atm);
		 }
		 else {
			 System.out.println("Authenticating pin success");
			 atm.setCurrentState(new AuthenticatedState());
		 }
		
	}

	@Override
	public void selectOperation(ATM atm, TransitionType transitionType, double amount) {
		// TODO Auto-generated method stub
		System.out.println("A card is already inserted");
		
	}

	@Override
	public void eject(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("Card has been ejected");
		atm.setCurrentCard(null);
		atm.setCurrentState(new IdleState());
		
	}

}
