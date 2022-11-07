package com.te.springbootemp.service;

import com.te.springbootemp.dto.EmployeeDto;
import com.te.springbootemp.dto.EmployeeLoginDto;
import com.te.springbootemp.entity.EmployeePrimaryInfo;

public interface EmployeeService {
	
	public EmployeePrimaryInfo register(EmployeePrimaryInfo primaryInfo);
	
	public EmployeePrimaryInfo getEmployee(String empId);
	
	public EmployeePrimaryInfo update(EmployeePrimaryInfo primaryInfo);
	
	public boolean delete(String empId);
	
	public EmployeeDto entityToDto(EmployeePrimaryInfo info);
	
	public EmployeePrimaryInfo dtoToEntity(EmployeeDto dto);

	public EmployeePrimaryInfo getLogin(EmployeeLoginDto dto);
	
	public EmployeePrimaryInfo getAll();
	
	public EmployeeDto addEmployee(EmployeeDto dto);
	
//	public EmployeeDto register2(EmployeeDto dto);
	
}
