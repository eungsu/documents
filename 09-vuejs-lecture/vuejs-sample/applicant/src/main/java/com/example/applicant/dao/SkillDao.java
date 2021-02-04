package com.example.applicant.dao;

import java.util.List;

import com.example.applicant.vo.HoldingSkill;
import com.example.applicant.vo.Skill;

public interface SkillDao {

    List<Skill> selectAllSkills();
    HoldingSkill insertHoldingSkill(HoldingSkill holdingSkill);
    List<HoldingSkill> selectHoldingSkillsByApplicantId(int applicantId);
    void deleteHoldingSkillsByApplicantId(int applicantId);
}