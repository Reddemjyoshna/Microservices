package com.Microservices.springbootrestapi.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Microservices.springbootrestapi.model.Employee;



@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	 @GetMapping
	    public ResponseEntity<List<Employee>> getEmployees(){
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee(1, "Ramesh", "Fadatare"));
	        employees.add(new Employee(2, "umesh", "Fadatare"));
	        employees.add(new Employee(3, "Ram", "Jadhav"));
	        employees.add(new Employee(4, "Sanjay", "Pawar"));
	        return ResponseEntity.ok(employees);
	    }
	 
	 @GetMapping("{id}/{first-name}/{last-name}")
	    public ResponseEntity<Employee> studentPathVariable(@PathVariable("id") int employeeId,
	                                       @PathVariable("first-name") String firstName,
	                                       @PathVariable("last-name") String lastName){
		 Employee employee = new Employee(employeeId, firstName, lastName);
	        return ResponseEntity.ok(employee);
	    }
	 
	 @GetMapping("query")
	    public ResponseEntity<Employee> studentRequestVariable(@RequestParam int id,
	                                          @RequestParam String firstName,
	                                          @RequestParam String lastName){
		 Employee employee = new Employee(id, firstName, lastName);
	        return ResponseEntity.ok(employee);
	    }
	 
	 @PostMapping("create")
	    //@ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
	        System.out.println(employee.getId());
	        System.out.println(employee.getFirstname());
	        System.out.println(employee.getLastname());
	        return new ResponseEntity<>(employee, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("{id}/update")
	    public ResponseEntity<Employee> updateStudent(@RequestBody Employee employee, @PathVariable("id") int employeeId){
	        System.out.println(employee.getFirstname());
	        System.out.println(employee.getLastname());
	        return ResponseEntity.ok(employee);
	    }
	 @DeleteMapping("{id}/delete")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){
	        System.out.println(employeeId);
	        return ResponseEntity.ok("Employee deleted successfully!");
	 }





}
