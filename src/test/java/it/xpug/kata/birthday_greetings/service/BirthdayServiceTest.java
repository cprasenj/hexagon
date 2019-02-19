package it.xpug.kata.birthday_greetings.service;

import it.xpug.kata.birthday_greetings.dal.Repository;
import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.notification.MessageService;
import org.junit.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class BirthdayServiceTest {

    private MessageService<Employee> emailService = mock(MessageService.class);
    private Repository<Employee> employeeRepository = mock(Repository.class);
    private BirthdayService birthdayService = new BirthdayService(emailService, employeeRepository);

    @Test
    public void sendGreetings() {
        XDate xDate = new XDate();
        when(employeeRepository.getAllByXDateField("isBirthday", xDate)).thenReturn(Collections.<Employee>emptyList());
        birthdayService.sendGreetings(xDate);
        verify(employeeRepository, times(1)).getAllByXDateField("isBirthday", xDate);

    }
}