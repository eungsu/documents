package com.example.applicant.form;

import java.util.List;

public class ApplicantForm {
    private String name;
    private String email;
    private boolean isAgreement;
    private int career;
    private String description;
    private List<Integer> skills;

    public ApplicantForm() {}

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

    public boolean isAgreement() {
        return isAgreement;
    }

    public void setAgreement(boolean isAgreement) {
        this.isAgreement = isAgreement;
    }

    public int getCareer() {
        return career;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getSkills() {
        return skills;
    }

    public void setSkills(List<Integer> skills) {
        this.skills = skills;
    }
    
}