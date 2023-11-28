package com.microservices.departmentsevices.service;

import com.microservices.departmentsevices.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);

}
