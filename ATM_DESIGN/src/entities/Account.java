package entities;

import java.util.HashMap;
import java.util.Map;

import exceptions.InsufficientBalanceException;


public class Account {
	private final String accountNumber;
	private double balance;
	private Map<String,Card> cards;
	
	public Account(String accountNumber,double balance) {
		this.accountNumber = accountNumber;
		this.balance =balance;
		this.setCards(new HashMap<>());
	}
	
	public synchronized void debit(double amount)  {
	 if(balance<amount) {System.out.println("Balance is low");}
	 else {
		 balance-= amount;
	 }
	}
	
	public synchronized void credit(double amount) {
		balance+= amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public Map<String,Card> getCards() {
		return cards;
	}

	public void setCards(Map<String,Card> cards) {
		this.cards = cards;
	}
}
