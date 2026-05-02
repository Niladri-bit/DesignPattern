package strategy;

import models.User;
import service.Chat;

public interface ChatMembershipStrategy {
    boolean validate(Chat chat, User user);
}