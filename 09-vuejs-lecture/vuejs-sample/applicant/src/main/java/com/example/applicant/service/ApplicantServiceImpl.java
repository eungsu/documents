package com.example.applicant.service;

import java.util.Date;
import java.util.List;

import com.example.applicant.dao.ApplicantDao;
import com.example.applicant.dao.SkillDao;
import com.example.applicant.vo.Applicant;
import com.example.applicant.vo.HoldingSkill;
import com.example.applicant.vo.Skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantDao applicantDao;

    @Autowired
    private SkillDao skillDao;
   
    public Applicant addApplicant(Applicant applicant, List<Integer> skills) {
        applicant.setCreatedDate(new Date());
        Applicant savendApplicant = applicantDao.insertApplicant(applicant);

        for (Integer skillId : skills) {
            HoldingSkill holdingSkill = new HoldingSkill();
            holdingSkill.setAppId(savendApplicant.getId());
            holdingSkill.setSkillId(skillId);

            skillDao.insertHoldingSkill(holdingSkill);
        }
        savendApplicant.setHoldingSkills(skillDao.selectHoldingSkillsByApplicantId(savendApplicant.getId()));

        return savendApplicant;
    }

    public Applicant modifyApplicant(Applicant applicant, List<Integer> skills) {
        applicantDao.updateApplicant(applicant);
        skillDao.deleteHoldingSkillsByApplicantId(applicant.getId());

        for (int skillId : skills) {
            HoldingSkill holdingSkill = new HoldingSkill();
            holdingSkill.setAppId(applicant.getId());
            holdingSkill.setSkillId(skillId);

            skillDao.insertHoldingSkill(holdingSkill);
        }

        return this.getApplicant(applicant.getId());
    }

    public void removeApplicant(int applicantId) {
        skillDao.deleteHoldingSkillsByApplicantId(applicantId);
        applicantDao.deleteApplicant(applicantId);
    }
    
    public Applicant getApplicant(int applicantId) {
        List<Applicant> applicants = applicantDao.selectApplicant(applicantId);
        if (applicants.isEmpty()) {
            return null;
        }
        Applicant saved = applicants.get(0);
        saved.setHoldingSkills(skillDao.selectHoldingSkillsByApplicantId(applicantId));
        
        return saved;
    }

    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = applicantDao.selectAllApplicants();
        for (Applicant applicant : applicants) {
            applicant.setHoldingSkills(skillDao.selectHoldingSkillsByApplicantId(applicant.getId()));
        }
        return applicants;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillDao.selectAllSkills();
    }
}