package com.microservices.employeesevices.service;

import com.microservices.employeesevices.EmployeeDto.APIResponseDto;
import com.microservices.employeesevices.EmployeeDto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployeeById(Long employeeId);

}
