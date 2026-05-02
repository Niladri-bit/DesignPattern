package strategy;

import java.util.ArrayList;
import java.util.List;

import models.Message;
import models.User;
import service.Chat;

public class SingleChatStrategy implements ChatStrategy {

    @Override
    public List<User> getRecipients(Chat chat, User sender) {
        List<User> recipients = new ArrayList<>();

        for (User user : chat.getUsers()) {
            if (!user.equals(sender)) {
                recipients.add(user);
            }
        }

        return recipients;
    }
}