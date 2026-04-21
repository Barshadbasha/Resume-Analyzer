package com.ResumeAnalyzer.demo.model;
import java.util.List;

public class ResumeResponse {




    private List<String> skills;
    private int experience;
    private int score;


    public List<String> getSkills() {
        return skills;
    }
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}