package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.JobDao;
import com.example.demo.vo.Department;
import com.example.demo.vo.Employee;
import com.example.demo.vo.Job;

@RestController
@RequestMapping("/hr")
public class HrController {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	JobDao jobDao;
	
	@Autowired
	DepartmentDao departmentDao;
	
	@GetMapping("/depts")
	public List<Department> departments() {
		return departmentDao.getAllDepartments();
	}
	
	@GetMapping("/jobs")
	public List<Job> jobs() {
		return jobDao.getAllJobs();
	}
	
	@GetMapping("/managers")
	public List<Employee> managers() {
		return employeeDao.getManagers();
	}
	
	@GetMapping("/employees")
	public List<Employee> employees() {
		return employeeDao.getEmployees(5);
	}
	
	
	@GetMapping("/employees/{id}")
	public Employee employee(@PathVariable("id") int id) {
		return employeeDao.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public List<Employee> insertEmployee(@RequestBody Employee employee) {
		employeeDao.insertEmployee(employee);
		return employeeDao.getEmployees(5);
	}
	
	@DeleteMapping("/employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int id) {
		employeeDao.deleteEmployee(id);
		return employeeDao.getEmployees(5);
	}
	
	@PutMapping("/employees/{id}")
	public List<Employee> updateEmployee(@RequestBody Employee employee) {
		employeeDao.updateEmployee(employee);
		return employeeDao.getEmployees(5);
	}
}
