package services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import entities.Account;
import entities.Card;

public class BankService {
	private Map<String,Account> accounts =new ConcurrentHashMap<>();
	private Map<String,Card> cards = new ConcurrentHashMap<String, Card>();
	private Map<Card,Account> accountsCardMap = new ConcurrentHashMap<Card, Account>();
	
	public BankService() {
		createAccount(1000,"account1");
		createCardForAccount("account1", "card", "1234");
	}
	
	public void createAccount(double balance,String accountId) {
		if(balance < (double)1000) {
			System.out.println("Minimum balance is 1000 to open account");
		}
		Account account = new Account(accountId, balance);
		accounts.put(accountId, account);
		System.out.println("Account created for account id: "+accountId);
	}
	
	public void createCardForAccount(String accountId,String cardNumber,String pin) {
		if(!accounts.containsKey(accountId)) {
			System.out.println("Please provide correct account id");
		}
        Card card=new Card(cardNumber,pin);
        cards.put(String.valueOf(cardNumber), card);
        accountsCardMap.put(card,accounts.get(accountId));
        System.out.printf("Card created for account id: %s with card number %s with pin %s%n",
                accountId, cardNumber, pin);	}
	
	public boolean authenticate(String card,String pin)  {
		if(!cards.containsKey(card)) { System.out.println("card is not valid");
		return false;}
		Card cardinserted = cards.get(card);
		if(!cardinserted.getPin().equals(pin)) {
			System.out.println("Invalid pin");
			return false;
		}
		return true;
	}
	
	public void debit(Card card,double amount)  {
		Account account =accountsCardMap.get(card);
		account.debit(amount);
	}
	
	public Card authenticate(String card) {
		return cards.getOrDefault(card, null);
	}
	
	public void credit(Card card,double amount) {
		Account account =accountsCardMap.get(card);
		account.credit(amount);
	}
	
	public void getBalance(Card card) {
		Account account =accountsCardMap.get(card);
		System.out.println("Current Balance is: "+account.getBalance());
	}
	
	public double getCurrentBalance(Card card) {
		Account account =accountsCardMap.get(card);
		return account.getBalance();
	}
}
