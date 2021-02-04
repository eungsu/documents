package com.example.applicant.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Applicant {
    private Integer id;
    private String name;
    private String email;
    private Boolean isAgreement;
    private Integer career;
    private String description;
    private Date createdDate;
    private List<HoldingSkill> holdingSkills = new ArrayList<>(); 
    
    public Applicant() {}
    
    public Applicant(Integer id, String name, String email, Boolean isAgreement, Integer career, String description,
            Date createdDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAgreement = isAgreement;
        this.career = career;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isAgreement() {
        return isAgreement;
    }

    public void setAgreement(Boolean isAgreement) {
        this.isAgreement = isAgreement;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedDateTime() {
        if (createdDate == null) {
            return null;
        }
        return createdDate.getTime();
    }

    public List<HoldingSkill> getHoldingSkills() {
        return holdingSkills;
    }

    public void setHoldingSkills(List<HoldingSkill> skills) {
        this.holdingSkills = skills;
    }

    public void addHoldingSkill(HoldingSkill holdingSkill) {
        holdingSkills.add(holdingSkill);
    }

}