package service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import enumerations.ChatType;
import models.Message;
import models.User;
import strategy.ChatStrategy;

public class ChatService {

    private static ChatService INSTANCE;

    private Map<Integer, User> userMap = new ConcurrentHashMap<>();
    private Map<Integer, Chat> chatMap = new ConcurrentHashMap<>();
    
    public List<Message> getChatHistory(Chat chat) {
        return chat.getMessages();
    }

    // ---------------- USER ----------------

    public User createUser(String name, int id) {
        User user = new User(id, name);
        userMap.put(id, user);
        return user;
    }

    // ---------------- CHAT ----------------

    public Chat createChat(ChatType chatType, List<Integer> userIds) {

        Chat chat = new Chat(chatType);

        for (Integer id : userIds) {
            User user = userMap.get(id);
            if (user != null) {
                chat.addUser(user);
            }
        }

        chatMap.put(chat.hashCode(), chat); // or maintain chatId getter
        return chat;
    }

    // ---------------- ADD USER TO CHAT ----------------

    public void addUserToChat(Chat chat, int userId) {

        User user = userMap.get(userId);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        chat.addUser(user);
    }

    // ---------------- SEND MESSAGE ----------------

    public void sendMessage(Chat chat, int senderId, String content) {

        User sender = userMap.get(senderId);

        Message message = new Message(
               1,
                sender,Instant.now(),
                content
        );

        chat.sendMessage(sender, message);
    }

    // ---------------- SINGLETON ----------------

    public static synchronized ChatService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChatService();
        }
        return INSTANCE;
    }
}