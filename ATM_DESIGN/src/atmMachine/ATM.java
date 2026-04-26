package atmMachine;

import entities.Card;
import enumerations.TransitionType;
import services.BankService;
import states.ATMState;
import states.IdleState;

public class ATM {
	private static ATM INSTANCE;
	private BankService bankService;
	private ATMState currentState;
	private Card CurrentCard;
	
	public ATM() {
		this.currentState =new IdleState();
		this.bankService = new BankService();
	}
	
	public static ATM getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ATM();
		}
		return INSTANCE;
	}
	
	
	public void changeState(ATMState state) {
		this.currentState =state;
	}

	public BankService getBankService() {
		return bankService;
	}

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}


	public Card getCurrentCard() {
		return CurrentCard;
	}

	public void setCurrentCard(Card currentCard) {
		CurrentCard = currentCard;
	}

	public ATMState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ATMState currentState) {
		this.currentState = currentState;
	}
	
	public void getBalance(Card CurrentCard) {
		bankService.getBalance(CurrentCard);
	}
	
	
	public void insertCard(ATM atm,String cardNumber) {
		currentState.insertCard(this, cardNumber);
	}
	public void authenticate(ATM atm ,String pin) {
		currentState.authenticate(this, pin);
	}
	public void selectOperation(ATM atm,TransitionType transitionType,double amount) {
		currentState.selectOperation(atm, transitionType, amount);
	}
	public void eject(ATM atm) {
		currentState.eject(atm);
	}
	
}
