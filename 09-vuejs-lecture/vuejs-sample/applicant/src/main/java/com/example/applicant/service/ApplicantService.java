package com.example.applicant.service;

import java.util.List;

import com.example.applicant.vo.Applicant;
import com.example.applicant.vo.Skill;

public interface ApplicantService {

    Applicant addApplicant(Applicant applicant, List<Integer> skills);
    Applicant modifyApplicant(Applicant applicant, List<Integer> skills);
    void removeApplicant(int applicantId);
    Applicant getApplicant(int applicantId);
    List<Applicant> getAllApplicants();

    List<Skill> getAllSkills();
}