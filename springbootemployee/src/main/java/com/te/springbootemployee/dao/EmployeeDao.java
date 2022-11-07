package com.te.springbootemployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.springbootemployee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {
	
	public Employee findByEmpId(String empId);

}
