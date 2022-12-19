package Modules;

import Enums.Qualifications;
import Interface.ManagerInterface;

public class Manager extends Staff implements ManagerInterface {

    public Manager() {
    }

    public Manager(Integer id, String firstName, String lastName, String email, Integer staffId) {
        super(id, firstName, lastName, email, staffId);
    }

    @Override
    public String toString() {
        return "Manager{} " + super.toString();
    }


    @Override
    public String hireApplicant(Applicant applicant) {
        String result = "";
        if(applicant.getTestScore() >= 50 && applicant.getQualifications()== Qualifications.BSC){
            result =  "You have been hired!";

        } else if (applicant.getTestScore() < 50 || applicant.getQualifications() == Qualifications.SSCE) {
            result = "Your application was unsuccessful";

        }

        return  result;

    }

}
