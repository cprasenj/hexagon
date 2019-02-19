package it.xpug.kata.birthday_greetings.dal;

import it.xpug.kata.birthday_greetings.domain.XDate;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    @Test
    public void getAllShouldReturnEmptyListIfThereAreNoEmployee() {
        EmployeeRepository employeeRepository = new EmployeeRepository("src/test/resources/empty.txt");
        assertEquals(0, employeeRepository.getAll().size());
    }

    @Test
    public void getAllShouldReturnAllEmployees() {
        EmployeeRepository employeeRepository = new EmployeeRepository("src/test/resources/employee.txt");
        assertEquals(2, employeeRepository.getAll().size());
    }

    @Test
    public void getAllByXDateField() throws ParseException {
        EmployeeRepository employeeRepository = new EmployeeRepository("src/test/resources/employee.txt");
        assertEquals(1, employeeRepository.getAllByXDateField("isBirthday", new XDate("1982/10/08")).size());
    }
}