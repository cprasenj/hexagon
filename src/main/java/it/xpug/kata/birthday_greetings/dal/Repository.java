package it.xpug.kata.birthday_greetings.dal;

import it.xpug.kata.birthday_greetings.domain.XDate;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
    List<T> getAllByXDateField(String field, XDate date);
}
