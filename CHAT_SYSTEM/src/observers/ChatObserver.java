package observers;

import java.util.List;

import models.Message;
import models.User;

public interface ChatObserver {
	void notify(List<User> recipient, Message message, User sender);
}