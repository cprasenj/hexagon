package it.xpug.kata.birthday_greetings.dal;

import it.xpug.kata.birthday_greetings.domain.XDate;
import it.xpug.kata.birthday_greetings.domain.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private String fileName;
    public EmployeeRepository(String fileName) {
        this.fileName = fileName;
    }

    public List<Employee> getAll() {
        BufferedReader in = null;
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String str = "";
        try {
            str = in.readLine();
            while ((str = in.readLine()) != null) {
                String[] employeeData = str.split(", ");
                Employee employee = new Employee(employeeData);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return employees;
    }

    public List<Employee> getAllByXDateField(String field, XDate date) {
        List<Employee> employees = getAll();
        Class employeeClass = Employee.class;
        List<Method> methods = new ArrayList<Method>();
        for (Method method:employeeClass.getMethods()) {
            String name=method.getName();
            if(name.toLowerCase().contains(field.toLowerCase())) {
                methods.add(method);
            }
        }

        if(methods.size() <= 0) {
            throw new Error("Wrong fieldName");
        }
        Method getter = methods.get(0);
        List<Employee> filteredEmployee = new ArrayList<Employee>();
        for (Employee e:employees) {
            try {
                if((Boolean)getter.invoke(e, date)) {
                    filteredEmployee.add(e);
                }
            } catch (IllegalAccessException e1) {
                System.out.println(e1.getMessage());
            } catch (InvocationTargetException e1) {
                System.out.println(e1.getMessage());
            }
        }
        return filteredEmployee;
    }
}
