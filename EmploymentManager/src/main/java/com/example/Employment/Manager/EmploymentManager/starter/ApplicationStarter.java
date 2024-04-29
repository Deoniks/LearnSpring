package com.example.Employment.Manager.EmploymentManager.starter;

import com.example.Employment.Manager.EmploymentManager.domain.Employee;
import com.example.Employment.Manager.EmploymentManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStarter implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        Employee empl = new Employee("Lepo","Fero","Junior HR",
                "HR","City,Loc,home");
        Employee eml = new Employee("Gerod","Jerro","Middle HR",
                "HR","City,Loc,home");
        Employee emp = new Employee("Miporo","Felicro","Senior HR",
                "HR","City,Loc,home");

        employeeService.save(empl);
        employeeService.save(eml);
        employeeService.save(emp);
    }
}
