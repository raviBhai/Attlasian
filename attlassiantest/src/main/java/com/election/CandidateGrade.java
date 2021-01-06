package com.election;



public class CandidateGrade {
    private String candidateName;
    private int grade;

    public CandidateGrade() {

    }

    public CandidateGrade(String candidateName, Integer grade) {
        this.candidateName = candidateName;
        this.grade = grade;
    }


    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
