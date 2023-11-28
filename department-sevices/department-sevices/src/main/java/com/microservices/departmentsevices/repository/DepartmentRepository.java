package com.microservices.departmentsevices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.departmentsevices.entity.Department;

public interface DepartmentRepository extends  JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
