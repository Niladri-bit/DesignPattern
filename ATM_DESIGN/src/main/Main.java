package main;

import atmMachine.ATM;
import enumerations.TransitionType;

public class Main {

	public static void main(String[] args) {
		
		
		ATM atm = ATM.getInstance();
		atm.insertCard(atm, "card");
		atm.authenticate(atm, "1234");
		atm.selectOperation(atm, TransitionType.BALANCE_ENQUIRY, 0);
		
		atm.insertCard(atm, "card");
		atm.authenticate(atm, "1234");
		atm.selectOperation(atm, TransitionType.WITHDRAW, 200);
		
		atm.insertCard(atm, "card");
		atm.authenticate(atm, "1234");
		atm.selectOperation(atm, TransitionType.WITHDRAW, 205);
		
		atm.insertCard(atm, "card");
		atm.authenticate(atm, "1234");
		atm.selectOperation(atm, TransitionType.WITHDRAW, 20);
		
		atm.insertCard(atm, "card");
		atm.authenticate(atm, "1234");
		atm.selectOperation(atm, TransitionType.DEPOSIT, 90);
	
	}
}
