package com.te.springbootemployee.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootemployee.dto.ResponseDto;
import com.te.springbootemployee.entity.Employee;
import com.te.springbootemployee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseDto> getById() {
		if (service.getEmployee() != null) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "Id found", service.getEmployee(), null), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResponseDto(true, "Id not found", null, null), HttpStatus.BAD_REQUEST);
	}

	
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> register(@RequestBody Employee employee) {
		if(service.register(employee)!=null){
			return new ResponseEntity<>(new ResponseDto(false, "Registration Successful",service.register(employee),null),HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ResponseDto(true, "Something went wrong", null, null), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> getLogin(@RequestBody Employee employee) {
		if(service.login(employee)!=null){
			return new ResponseEntity<ResponseDto>(new ResponseDto(false,"Login Successful",service.login(employee),null),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(new ResponseDto(true, "invalid credentials", null, null),
					HttpStatus.BAD_REQUEST);
		}
	}
	
}
