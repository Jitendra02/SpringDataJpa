package com.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	Employee findById(int Id);
}
