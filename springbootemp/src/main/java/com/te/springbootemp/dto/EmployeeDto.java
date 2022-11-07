package com.te.springbootemp.dto;

import java.util.List;

import javax.persistence.Id;

import com.te.springbootemp.entity.EmployeeEducationInfo;
import com.te.springbootemp.entity.EmployeeSecondaryInfo;
import com.te.springbootemp.entity.EmployeeSkills;

import lombok.Data;



@Data
public class EmployeeDto {
	
//	public EmployeeDto(boolean b, String string, EmployeeDto dto) {
//		// TODO Auto-generated constructor stub
//	}

	
	private String empId;
	private String empName;
	private String empAge;
	private String empJob;
	private String empBloodGrp;
	private String empMailId;
	private String empDob;
	private String maritalStatus;
	private String empGender;
	private String empDeptNo;
	private String password;
	
	
	private EmployeeSecondaryInfo secondaryInfo;
	
	private List<EmployeeEducationInfo> educationInfo;
	
	private List<EmployeeSkills> skills;
	
	

}
