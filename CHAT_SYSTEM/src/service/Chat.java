package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import enumerations.ChatType;
import models.Message;
import models.User;
import observers.ChatObserver;
import observers.Observable;
import strategy.ChatMembershipStrategy;
import strategy.ChatStrategy;
import strategy.GroupChatStrategy;
import strategy.GroupMembershipStrategy;
import strategy.OneToOneMembershipStrategy;
import strategy.SingleChatStrategy;

public class Chat implements Observable{

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private int chatId;
    private List<Message> messages;
    private Set<User> users;
    private ChatStrategy chatStrategy;
    private List<ChatObserver> observers;
    private ChatMembershipStrategy chatMembershipStrategy;
    
    public Chat(ChatType chatType) {
    	if(chatType.equals(ChatType.ONE_TO_ONE)) {
    		chatStrategy = new SingleChatStrategy();
    		chatMembershipStrategy = new OneToOneMembershipStrategy();
    	}
    	else if(chatType.equals(ChatType.GROUP)) {
    		chatStrategy = new GroupChatStrategy();
    		chatMembershipStrategy = new GroupMembershipStrategy();
    	}
        this.chatId = ID_GENERATOR.getAndIncrement();
        this.users = new HashSet<>();
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void sendMessage(User sender, Message message) {

        if (!validateSender(sender)) {
            throw new RuntimeException("User not part of chat");
        }

        // ✅ common logic
        messages.add(message);

        // ✅ strategy decides recipients
        List<User> recipients = chatStrategy.getRecipients(this, sender);

        for (ChatObserver observer : observers) {
                observer.notify(recipients, message, sender);
            
        }
    }

    private boolean validateSender(User user) {
        return users.contains(user);
    }

    public Set<User> getUsers() {
        return users;
    }
    
    public void addUser(User user) {
    	 if(chatMembershipStrategy.validate(this, user)) {
    		 users.add(user);
    	 }else {System.out.println("Can't add more users");}
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<Message> getMessages() {
        return new ArrayList<>(messages); // defensive copy
    }
    
    @Override
    public void register(ChatObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(ChatObserver observer) {
        observers.remove(observer);
    }

	
}