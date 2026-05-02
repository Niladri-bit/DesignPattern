package models;

import java.time.Instant;

public class Message {
	private int messageId;
	private User user;
	private Instant time;
	private String messageContent;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Message(int messageId, User user, Instant time,String messageContent) {
		super();
		this.messageId = messageId;
		this.user = user;
		this.time = time;
		this.messageContent=messageContent;
	}
	
	
}
