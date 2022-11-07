package com.te.springbootemp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.te.springbootemp.entity.EmployeePrimaryInfo;

public interface EmployeeDao extends JpaRepository<EmployeePrimaryInfo, String> {
	
	public EmployeePrimaryInfo findByEmpId(String empId);

	
//	@Query("from Employee")
//	public List<EmployeePrimaryInfo> getAllEmployees();
	
	

}
