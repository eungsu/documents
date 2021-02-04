package com.example.applicant.web;

import java.util.Arrays;

import com.example.applicant.dto.ResultDto;
import com.example.applicant.form.ApplicantForm;
import com.example.applicant.service.ApplicantService;
import com.example.applicant.vo.Applicant;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;
    
    @GetMapping("/skills")
    public ResultDto getSkills() {
        return new ResultDto("보유기술 항목", applicantService.getAllSkills());
    }

    @GetMapping("/applicants")
    public ResultDto getApplicants() {
        return new ResultDto("전체 지원자", applicantService.getAllApplicants());
    }

    @GetMapping("/applicants/{id}")
    public ResultDto getApplicant(@PathVariable("id") int applicantId) {
        Applicant applicant = applicantService.getApplicant(applicantId);
        if (applicant == null) {
            return new ResultDto("["+applicantId+"]번 지원자 정보", "NotFound", "["+applicantId+"]번에 해당하는 지원자 정보가 존재하지 않습니다.");
        }
        return new ResultDto("지원자 정보", "["+applicantId+"]번 지원자의 상세정보", Arrays.asList(applicant));
    }

    @PostMapping("/applicants")
    public ResultDto addApplicant(@RequestBody ApplicantForm applicantForm) {
        Applicant applicant = new Applicant();
        BeanUtils.copyProperties(applicantForm, applicant);
        Applicant saved = applicantService.addApplicant(applicant, applicantForm.getSkills());
        return new ResultDto("지원자 정보 추가", "["+saved.getName()+"] 지원자정보가 추가되었습니다.", Arrays.asList(saved));
    }

    @PutMapping("/applicants/{id}")
    public ResultDto modifyApplicant(@PathVariable("id") int applicantId, @RequestBody ApplicantForm applicantForm) {
        Applicant applicant = new Applicant();
        applicant.setId(applicantId);
        BeanUtils.copyProperties(applicantForm, applicant);

        
        Applicant saved = applicantService.modifyApplicant(applicant, applicantForm.getSkills());
        
        return new ResultDto("지원자 정보 변경", "["+saved.getName()+"] 지원자정보가 추가되었습니다.", Arrays.asList(saved));
    }

    @DeleteMapping("/applicants/{id}")
    public ResultDto removeApplicant(@PathVariable("id") int applicantId) {
        applicantService.removeApplicant(applicantId);

        return new ResultDto("지원자 정보 삭제", "OK");
    }
}