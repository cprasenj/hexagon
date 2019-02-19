package it.xpug.kata.birthday_greetings;

import it.xpug.kata.birthday_greetings.dal.EmployeeRepository;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.service.BirthdayService;
import it.xpug.kata.birthday_greetings.notification.EmailService;

import javax.mail.*;

public class Main {

	public static void main(String[] args) throws MessagingException {
		String fileName = "employee_data.txt";
		EmployeeRepository employeeRepository = new EmployeeRepository(fileName);
		EmailService emailService = new EmailService( "localhost", 25);
		BirthdayService service = new BirthdayService(emailService, employeeRepository);
		service.sendGreetings(new XDate());
	}

}
