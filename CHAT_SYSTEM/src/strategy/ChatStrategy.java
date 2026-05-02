package strategy;

import java.util.List;

import models.Message;
import models.User;
import service.Chat;

public interface ChatStrategy {
    List<User> getRecipients(Chat chat, User sender);
}
