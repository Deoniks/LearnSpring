package com.example.Employment.Manager.EmploymentManager.controller;

import com.example.Employment.Manager.EmploymentManager.domain.Employee;
import com.example.Employment.Manager.EmploymentManager.repository.EmployeeRepository;
import com.example.Employment.Manager.EmploymentManager.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestBody("/employee") -> Понять в чём проблема...
@Service
public class EmployeeController implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    @GetMapping("/findAll")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    @PostMapping("/save")
    public void save(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    @PutMapping("/updateBy/{id}")
    public Employee upd(@RequestBody Employee employee, @PathVariable Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        emp = employee; //
        return employeeRepository.save(emp);
    }

    @Override
    @DeleteMapping("/delete")
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @GetMapping("/findBy/{id}")
    public Employee getById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}




