package com.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.entity.Employee;
import com.springjpa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping(value="/addEditEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp){
		
		String response = empService.addEditEmployee(emp);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//-------------------------------------------------------------------------
	
	@GetMapping(value="/getEmployeeList")
	public ResponseEntity<Object> getAllEmployee(){
		
		List<Employee> response = empService.getAllEmployees();
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//-------------------------------------------------------------------------
	
	@GetMapping(value="/getEmployee/{id}")
	public ResponseEntity<Object> getEmployee(
								@PathVariable("id") int id
		){
		
		Employee response = empService.getEmployee(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	//-------------------------------------------------------------------------
	
	@GetMapping(value="/deleteEmployee/{id}")
	public ResponseEntity<Object> deleteEmployee(
								@PathVariable("id") int id
		){
		
		String response = empService.deleteEmployee(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	//-------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
//End of file
//------------------------------------------------------------------------------