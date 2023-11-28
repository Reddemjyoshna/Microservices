package com.microservices.employeesevices.service.impl;

import org.springframework.stereotype.Service;

import com.microservices.employeesevices.EmployeeDto.APIResponseDto;
import com.microservices.employeesevices.EmployeeDto.DepartmentDto;
import com.microservices.employeesevices.EmployeeDto.EmployeeDto;
import com.microservices.employeesevices.entity.Employee;
import com.microservices.employeesevices.repository.EmployeeRepository;
import com.microservices.employeesevices.service.APIClient;
import com.microservices.employeesevices.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	private APIClient apiClient;
	
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, APIClient apiClient) {
		super();
		this.employeeRepository = employeeRepository;
		this.apiClient = apiClient;
	}

	

	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode()
		);
		Employee saveDemployee = employeeRepository.save(employee);
		
		EmployeeDto savedemployeeDto = new EmployeeDto(
				saveDemployee.getId(),
				saveDemployee.getFirstName(),
				saveDemployee.getLastName(),
				saveDemployee.getEmail(),
				saveDemployee.getDepartmentCode()
		);
		
		
		
		return savedemployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee =employeeRepository.findById(employeeId).get();
		
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
		);
		APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
    
        return apiResponseDto;
		
	}
	

}
