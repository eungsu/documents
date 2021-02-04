package com.example.applicant.vo;

import java.util.Date;

public class HoldingSkill {
    private Integer id;
    private Integer appId;
    private Integer skillId;
    private String skillName;
    private String skillLabel;
    private Date createdDate;
    
    public HoldingSkill() {}
    
    public HoldingSkill(Integer id, Integer appId, Integer skillId, Date createdDate) {
        this.id = id;
        this.appId = appId;
        this.skillId = skillId;
        this.createdDate = createdDate;
    }
    
    public HoldingSkill(Integer id, Integer appId, Integer skillId, String skillName, String skillLabel,  Date createdDate) {
        this.id = id;
        this.appId = appId;
        this.skillId = skillId;
        this.skillName = skillName;
        this.skillLabel = skillLabel;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillLabel() {
        return skillLabel;
    }

    public void setSkillLabel(String skillLabel) {
        this.skillLabel = skillLabel;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    
    

    
}