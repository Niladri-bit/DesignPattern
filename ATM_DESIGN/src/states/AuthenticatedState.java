package states;

import atmMachine.ATM;
import chainOfResponsibility.CashHandler;
import chainOfResponsibility.CashHandlerFactory;
import enumerations.TransitionType;

public class AuthenticatedState implements ATMState {

	@Override
	public void insertCard(ATM atm, String cardNumber) {
		// TODO Auto-generated method stub
		System.out.println("A card is already doing some operation");
		
	}

	@Override
	public void authenticate(ATM atm, String pin) {
		System.out.println("A card is already doing some operation");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOperation(ATM atm, TransitionType transitionType, double amount) {
		// TODO Auto-generated method stub
		switch(transitionType){
			case BALANCE_ENQUIRY:
				atm.getBalance(atm.getCurrentCard());
				break;
			case DEPOSIT:
				if(amount<=0) {
					System.out.println("Invalid amount specified");
					break;
				}else {
					System.out.println("Before credit");
					atm.getBalance(atm.getCurrentCard());
					atm.getBankService().credit(atm.getCurrentCard(), amount);
					System.out.println("After credit");
					atm.getBalance(atm.getCurrentCard());
					break;
				}
			case WITHDRAW:
				if(amount>atm.getBankService().getCurrentBalance(atm.getCurrentCard())) {
					System.out.println("Low Balance");
					break;
				}
				else {
					System.out.println("Before credit");
					atm.getBalance(atm.getCurrentCard());
					CashHandler chain = CashHandlerFactory.buildChain();

					int amount1 = (int) amount;

					// STEP 1: Validate
					if (amount1 % 10 != 0) {
					    System.out.println("Invalid amount (not divisible by 10)");
					    return;
					}

					if (chain.canHandle(amount1) != 0) {
					    System.out.println("ATM cannot dispense exact amount");
					    return;
					}

					// STEP 2: Debit
					atm.getBankService().debit(atm.getCurrentCard(), amount1);

					// STEP 3: Dispense
					chain.dispense(amount1);
					System.out.println("After credit");
					atm.getBalance(atm.getCurrentCard());
					break;
				}
			default:
				System.out.println("Invalid operation");
				break;			
		}
		System.out.println("Card Operation done");
		eject(atm);
		
	}

	@Override
	public void eject(ATM atm) {
		// TODO Auto-generated method stub
		System.out.println("Card has been ejected");
		atm.setCurrentCard(null);
		atm.setCurrentState(new IdleState());
	}

}
