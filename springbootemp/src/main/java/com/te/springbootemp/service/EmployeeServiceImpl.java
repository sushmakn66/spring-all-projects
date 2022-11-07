package com.te.springbootemp.service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.springbootemp.dao.EmployeeDao;
import com.te.springbootemp.dto.EmployeeDto;
import com.te.springbootemp.dto.EmployeeLoginDto;
import com.te.springbootemp.entity.EmployeeEducationInfo;
import com.te.springbootemp.entity.EmployeePrimaryInfo;
import com.te.springbootemp.entity.EmployeeSkills;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	

	@Autowired
	private EmployeeDao dao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public EmployeePrimaryInfo register(EmployeePrimaryInfo primaryInfo) {
		List<EmployeePrimaryInfo> infos=new ArrayList<>();
		infos.add(primaryInfo);
		for (EmployeeSkills iterable_element : primaryInfo.getSkills()) {
			iterable_element.setPrimaryInfo(infos);
		}
		return dao.save(primaryInfo);
	}

	@Override
	public EmployeePrimaryInfo getEmployee(String empId) {
		return dao.findByEmpId(empId);
	}

	@Override
	public EmployeePrimaryInfo update(EmployeePrimaryInfo primaryInfo) {
		return dao.save(primaryInfo);
		
	}
	
	ModelMapper mapper1=new ModelMapper();
	@Override
	public EmployeeDto entityToDto(EmployeePrimaryInfo info) {
		EmployeeDto map = mapper1.map(info, EmployeeDto.class);
		return map;
	}
	
	
	@Override
	public EmployeePrimaryInfo dtoToEntity(EmployeeDto dto) {
		EmployeePrimaryInfo map1 = mapper1.map(dto, EmployeePrimaryInfo.class);
		return map1;
	}

	@Override
	public EmployeePrimaryInfo getLogin(EmployeeLoginDto dto) {
		EmployeePrimaryInfo employee=dao.findByEmpId(dto.getEmpId());
		if(employee !=null && employee.getSecondaryInfo()!=null) {
			return employee;
		}
		return null;
	}

	@Override
	public boolean delete(String empId) {
		boolean isDeleted = false;
		try {
			dao.deleteById(empId);
			isDeleted = true;
		} catch (Exception e) {
		}
		return isDeleted;
	}

	@Override
	public EmployeePrimaryInfo getAll() {
		List<EmployeePrimaryInfo> findAll=(List<EmployeePrimaryInfo>) dao.findAll();
		List<EmployeePrimaryInfo> list = new ArrayList<>();
		for (EmployeePrimaryInfo employee : findAll) {
			if (employee.getSecondaryInfo() != null) {
				EmployeePrimaryInfo dataReturn = new EmployeePrimaryInfo();
				list.add(dataReturn);
			}
		}
		return (EmployeePrimaryInfo) list;
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		EmployeePrimaryInfo map=this.mapper.map(dto, EmployeePrimaryInfo.class);
		map.getSecondaryInfo().setPrimaryInfo(map);
		for (EmployeeEducationInfo e : map.getEducationInfo()) {
			e.setPrimaryInfo(map);
		}
		List<EmployeePrimaryInfo> list=new ArrayList<>();
		list.add(map);
		
		List<EmployeeSkills> skills=new ArrayList<>();
		skills.addAll(map.getSkills());
		
		for(EmployeeSkills e:map.getSkills()) {
			e.setPrimaryInfo(list);
			for (EmployeePrimaryInfo emp : e.getPrimaryInfo()) {
				e.setPrimaryInfo(list);
			}
		}
		EmployeePrimaryInfo save=dao.save(map);
		return this.mapper.map(save, EmployeeDto.class);
	}

//	@Override
//	public EmployeeDto register2(EmployeeDto dto) {
//		EmployeePrimaryInfo primaryInfo = this.mapper.map(dto, EmployeePrimaryInfo.class);
//		primaryInfo.getSecondaryInfo().setPrimaryInfo(primaryInfo);
//		for(EmployeeEducationInfo info:primaryInfo.getEducationInfo()) {
//			info.setPrimaryInfo(primaryInfo);
//		}
//		List<EmployeePrimaryInfo> infos=new ArrayList<>();
//		infos.add(primaryInfo);
//		List<EmployeeSkills> skills=new ArrayList<>();
//		log.info("double check");
//		skills.addAll(primaryInfo.getSkills());
//		log.info("double");
//		for (EmployeeSkills emp : primaryInfo.getSkills()) {
//			emp.setPrimaryInfo(infos);
//			for(EmployeePrimaryInfo e:emp.getPrimaryInfo()) {
//				emp.setPrimaryInfo(infos);
//			}
//		}
//		log.info("check all {}",primaryInfo.getSkills());
//		EmployeePrimaryInfo save = dao.save(primaryInfo);
//		return this.mapper.map(save, EmployeeDto.class);
//	}
	
	

	
	
	
	
	


	

}
