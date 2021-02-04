package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.Job;

@Mapper
public interface JobDao {

	List<Job> getAllJobs();
}
