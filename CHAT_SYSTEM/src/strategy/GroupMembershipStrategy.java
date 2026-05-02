package strategy;

import models.User;
import service.Chat;

public class GroupMembershipStrategy implements ChatMembershipStrategy {

    @Override
    public boolean validate(Chat chat, User user) {
    	return true;
    }

	
}