package com.springjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.entity.Employee;
import com.springjpa.repository.EmployeeRepo;

/**
 * This Service contains Crud Operations method for Employee Entity
 * @author jitendrapatil
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	/**
	 * This methods return all employees from database
	 * @return
	 */
	public List<Employee> getAllEmployees(){
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList = employeeRepo.findAll();
		
		return employeeList;
	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * This method returns employee entity based in Id
	 * @param Id
	 * @return
	 */
	public Employee getEmployee(int Id) {
		
		Employee emp = employeeRepo.findById(Id);
		
		return emp;
	}
	
	//-------------------------------------------------------------------------
	
	/**
	 * This method will add/edit employee based on Id.
	 * If Id is passed in employee Object it will update that employee
	 *  otherwise new employee will be added
	 * @param employee
	 * @return
	 */
	public String addEditEmployee(Employee employee) {
		
		employeeRepo.save(employee);
		
		return "Added/Edited Employee";
	}
	//-------------------------------------------------------------------------
	
	/**
	 * This method deletes employee based on id
	 * @param id
	 * @return
	 */
	public String deleteEmployee(int id) {
		
		employeeRepo.deleteById(id);
		
		return "Employee deleted";
   }
	//--------------------------------------------------------------------------
}
//------------------------------------------------------------------------------
// End of file
//------------------------------------------------------------------------------