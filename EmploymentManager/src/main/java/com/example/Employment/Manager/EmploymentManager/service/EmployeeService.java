package com.example.Employment.Manager.EmploymentManager.service;

import com.example.Employment.Manager.EmploymentManager.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>getAll();
    void save(Employee employee);
    void delete(Employee employee);
    void deleteById(Long id);
    Employee upd(Employee employee,Long id);
    Employee getById(Long id);
}
