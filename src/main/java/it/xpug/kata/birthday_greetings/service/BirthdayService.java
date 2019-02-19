package it.xpug.kata.birthday_greetings.service;

import it.xpug.kata.birthday_greetings.dal.Repository;
import it.xpug.kata.birthday_greetings.domain.Employee;
import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.notification.MessageService;

public class BirthdayService {

	private MessageService<Employee> emailService;
	private Repository<Employee> employeeRepository;

	public BirthdayService(MessageService<Employee> emailService, Repository<Employee> employeeRepository) {
		this.emailService = emailService;
		this.employeeRepository = employeeRepository;
	}

	public void sendGreetings(XDate xDate) {
		emailService.sendMessage(employeeRepository.getAllByXDateField("isBirthday", xDate));
	}
}
