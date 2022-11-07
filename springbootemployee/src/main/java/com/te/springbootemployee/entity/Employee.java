package com.te.springbootemployee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="emp_info")
public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private String empEmail;
	private String password;
	
	

}
