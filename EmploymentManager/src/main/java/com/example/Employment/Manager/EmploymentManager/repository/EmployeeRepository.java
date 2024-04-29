package com.example.Employment.Manager.EmploymentManager.repository;

import com.example.Employment.Manager.EmploymentManager.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
     List<Employee> findByPosition(Employee employee);
}
