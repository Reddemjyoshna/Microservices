package com.microservices.departmentsevices.service.impl;

import org.springframework.stereotype.Service;

import com.microservices.departmentsevices.dto.DepartmentDto;
import com.microservices.departmentsevices.entity.Department;
import com.microservices.departmentsevices.repository.DepartmentRepository;
import com.microservices.departmentsevices.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	//we are using constructor bases dependency injection so need to use autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}


	
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// convert department dto to department jpa entity
		Department department = new Department(
				departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
		);
		Department savedDepartment = departmentRepository.save(department);
		
		
		// convert department jpa to department dto entity
		DepartmentDto savedDepartmentDto = new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode()
        );
		return savedDepartmentDto;

		
	}



	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		//jpa entity
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		//converting to dto
		DepartmentDto departmentDto =new DepartmentDto(
				department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
				
				);
		return departmentDto;
	}

}
