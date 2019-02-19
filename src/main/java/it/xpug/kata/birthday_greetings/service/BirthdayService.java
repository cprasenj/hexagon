package it.xpug.kata.birthday_greetings.service;

import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.dal.Repository;
import it.xpug.kata.birthday_greetings.domain.Employee;

import javax.mail.MessagingException;

public class BirthdayService {

	private EmailService emailService;
	private Repository<Employee> employeeRepository;

	public BirthdayService(EmailService emailService, Repository<Employee> employeeRepository) {
		this.emailService = emailService;
		this.employeeRepository = employeeRepository;
	}

	public void sendGreetings(XDate xDate) throws MessagingException {
		emailService.sendMessage(employeeRepository.getAllByXDateField("isBirthday", xDate));
	}
}
