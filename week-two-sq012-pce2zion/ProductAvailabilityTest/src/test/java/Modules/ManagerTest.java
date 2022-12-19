package Modules;

import Enums.Qualifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void hireApplicant() {
        Manager manager = new Manager(1, "Tunde", "Makin", "tude@gmail.com", 1);
        Applicant applicant2 =new Applicant(2, "Mercy", "Eke", "mercy@gmail.com", 90, Qualifications.BSC);
        Applicant applicant1 = new Applicant(1, "Femi", "Famo","fem@gmail.com", 60, Qualifications.SSCE);


        String  result =  "You have been hired!";
        String badResult = "Your application was unsuccessful";

        String toHire = manager.hireApplicant(applicant2);
        String toHire2 = manager.hireApplicant((applicant1));

        Assertions.assertEquals(result, toHire);
        Assertions.assertEquals(badResult, toHire2);

    }
}