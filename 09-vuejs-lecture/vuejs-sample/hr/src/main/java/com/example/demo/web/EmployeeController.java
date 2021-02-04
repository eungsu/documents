package com.example.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.EmployeesMapper;
import com.example.demo.vo.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeesMapper mapper;

	@RequestMapping("/search")
	@ResponseBody
	public List<Employee> search(
			@RequestParam(value = "opt", required = false) String opt, 
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "pageno", required = false, defaultValue = "1") int pageNo) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("opt", opt);
		param.put("keyword", keyword);
		param.put("pageNo", pageNo);
		
		return mapper.searchEmployees(param);
	}
}
