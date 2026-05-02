package models;

import observers.ChatObserver;

public class User {
	private int userId;
	private String name;
	
	public User(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getNotified(String sender,String message,String receiver) {
		System.out.println(getName() +"received message from "+ sender +" : "+message);
	}
	
	
	
}
