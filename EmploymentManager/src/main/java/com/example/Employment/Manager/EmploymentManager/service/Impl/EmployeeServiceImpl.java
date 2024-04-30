package com.example.Employment.Manager.EmploymentManager.service.Impl;

import com.example.Employment.Manager.EmploymentManager.domain.Employee;
import com.example.Employment.Manager.EmploymentManager.repository.EmployeeRepository;
import com.example.Employment.Manager.EmploymentManager.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public Employee upd(@RequestBody Employee employee, @PathVariable Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        emp = employee; //
        return employeeRepository.save(emp);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
