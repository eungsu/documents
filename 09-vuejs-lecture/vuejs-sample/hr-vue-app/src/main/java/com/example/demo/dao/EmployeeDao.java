package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Employee;

@Mapper
public interface EmployeeDao {

	List<Employee> getEmployees(int limit);
	List<Employee> getManagers();
	Employee getEmployee(int id);
	void insertEmployee(Employee employee);
	void deleteEmployee(int id);
	void updateEmployee(Employee employee);
}
