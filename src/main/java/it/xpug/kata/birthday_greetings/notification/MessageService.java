package it.xpug.kata.birthday_greetings.notification;

import java.util.List;

public interface MessageService<T> {
    void sendMessage(List<T> list);
}
