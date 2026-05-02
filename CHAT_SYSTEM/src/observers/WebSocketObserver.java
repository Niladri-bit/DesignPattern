package observers;

import java.util.List;

import models.Message;
import models.User;

public class WebSocketObserver implements ChatObserver {

	@Override
	public void notify(List<User> recipients, Message message, User sender) {

	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < recipients.size(); i++) {
	        sb.append(recipients.get(i).getName());

	        if (i != recipients.size() - 1) {
	            sb.append(", ");
	        }
	    }

	    sb.append(" got message from ")
	      .append(sender.getName())
	      .append(" : ")
	      .append(message.getMessageContent());

	    System.out.println(sb.toString());
	}

	
}