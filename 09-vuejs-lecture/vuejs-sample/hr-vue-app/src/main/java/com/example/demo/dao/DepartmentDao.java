package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Department;

@Mapper
public interface DepartmentDao {

	List<Department> getAllDepartments();
}
