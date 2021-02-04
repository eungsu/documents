package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Employee;

@Mapper
public interface EmployeesMapper {

	List<Employee> searchEmployees(Map<String, Object> param);
}
