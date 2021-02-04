package com.example.applicant.dao;

import java.util.List;

import com.example.applicant.vo.Applicant;

public interface ApplicantDao {

    Applicant insertApplicant(Applicant applicant);
    void updateApplicant(Applicant applicant);
    void deleteApplicant(Integer id);
    List<Applicant> selectApplicant(Integer id);
    List<Applicant> selectAllApplicants();
}