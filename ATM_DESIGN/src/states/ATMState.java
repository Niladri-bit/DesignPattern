package states;

import atmMachine.ATM;
import enumerations.TransitionType;

public interface ATMState {
	void insertCard(ATM atm,String cardNumber);
	void authenticate(ATM atm ,String pin);
	void selectOperation(ATM atm,TransitionType transitionType,double amount);
	void eject(ATM atm);
}
