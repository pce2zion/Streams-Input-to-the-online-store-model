package Modules;

import Enums.Qualifications;

public class Applicant extends Person{
    private Integer testScore;


    private Qualifications qualifications;


    public Applicant() {
    }


    public Applicant(Integer id, String firstName, String lastName, String email, Integer testScore, Qualifications qualifications) {
        super(id, firstName, lastName, email);
        this.testScore = testScore;
        this.qualifications = qualifications;
    }

    public Integer getTestScore() {
        return testScore;
    }

    public void setTestScore(Integer testScore) {
        this.testScore = testScore;
    }

    public Qualifications getQualifications() {
        return qualifications;
    }

    public void setQualifications(Qualifications qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "testScore=" + testScore +
                ", qualifications=" + qualifications +
                "} " + super.toString();
    }
}
