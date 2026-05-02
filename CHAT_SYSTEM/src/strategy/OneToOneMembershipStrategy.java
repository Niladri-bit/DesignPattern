package strategy;

import models.User;
import service.Chat;

public class OneToOneMembershipStrategy implements ChatMembershipStrategy {

    @Override
    public boolean validate(Chat chat, User user) {

        if (chat.getUsers().size() >= 2) {
            return false;
        }

        return true;
    }

	
}