package client;

import java.util.List;

import enumerations.ChatType;
import models.Message;
import observers.WebSocketObserver;
import service.Chat;
import service.ChatService;
import strategy.GroupChatStrategy;

public class Client {

	public static void main(String[] args) {
		ChatService service = ChatService.getInstance();

		service.createUser("A", 1);
		service.createUser("B", 2);
		service.createUser("C", 3);
		service.createUser("D", 4);
		service.createUser("E", 5);

		Chat chat = service.createChat(ChatType.GROUP,List.of(1));
		chat.register(new WebSocketObserver());
		service.addUserToChat(chat, 2); // 👈 THIS is how user joins chat
		service.addUserToChat(chat, 3);
		service.addUserToChat(chat, 5);
		service.sendMessage(chat,1, "hello");
		service.sendMessage(chat,2, "hey hi A");
		
		List<Message> history = service.getChatHistory(chat);

		for (Message m : history) {
		    System.out.println(
		        m.getUser().getName() +
		        " -> " +
		        m.getMessageContent()
		    );
		}
	}
}
