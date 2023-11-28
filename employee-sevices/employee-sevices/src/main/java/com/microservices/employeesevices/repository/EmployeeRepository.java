package com.microservices.employeesevices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.employeesevices.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
