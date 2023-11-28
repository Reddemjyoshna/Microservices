package com.microservices.employeesevices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.employeesevices.EmployeeDto.DepartmentDto;


@FeignClient(url="http://localhost:8080", value="DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/department/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
        
  
    }

