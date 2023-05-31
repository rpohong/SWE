import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class updateJobTest {
    @Test  // valid inputs as addJob
    void UpdateJobTest_1_validinputs(){

        Job updateTest1_1Valid = new Job ("32224RMI^","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Senior","F",new String[]{"Skill 1","Skill 2","None"},100000,"G");
        Job updateTest1_2Valid =new Job ("12345mmm_","A","B","New York,state,USA",
                "2023-12-05", "Senior","F",new String[]{"skills 1","Skills 2","Skills 3"},100000,"G");
        assertAll("",
                ()->assertEquals(true,updateTest1_1Valid.addJob()),
                ()->assertEquals(true,updateTest1_2Valid.addJob())
        );

    }
    @Test // the salary of Junior jobs should not be increased by more than 10%.
    void UpdateJobTest_2_salary(){

        Job UpdateJobTest2_1Invalid = new Job ("12341mmm_","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Junior","F",new String[]{"Skill 1","Skill 2","None"},45000,"G");
        Job UpdateJobTest2_2Invalid = new Job ("12342mmm_","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Junior","F",new String[]{"Skill 1","Skill 2","None"},70000,"G");
        assertAll("",
                ()->assertEquals(false,UpdateJobTest2_1Invalid.updateJob()),
                ()->assertEquals(false,UpdateJobTest2_2Invalid.updateJob())
                );

    }
    @Test
    void UpdateJobTest_3_salary(){

        Job UpdateJobTest3_1valid = new Job ("12341mmm_","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Junior","Full-time",new String[]{"Skill 1","Skill 2","None"},42000,"G");
        Job UpdateJobTest3_2valid = new Job ("12342mmm_","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Junior","Full-time",new String[]{"Skill 1","Skill 2","None"},65000,"G");
        assertAll("",
                ()->assertEquals(true,UpdateJobTest3_1valid.updateJob()),
                ()->assertEquals(true,UpdateJobTest3_2valid.updateJob())
        );

    }
    @Test
    void UpdateJobTest_4_updateJob(){
        Job updateTest3_1Valid = new Job ("12352XXA","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Junior","Internship",new String[]{"Skill 1","Skill 2","None"},100000,"G");
        Job updateTest3_2Valid =new Job ("12352XXA","A","B","New York,state,USA",
                "2023-12-05", "Junior","Internship",new String[]{"skills 1","Skills 2","Skills 3"},100000,"G");
        assertAll("",
                ()->assertEquals(true,updateTest3_1Valid.addJob()),
                ()->assertEquals(true,updateTest3_2Valid.addJob())
        );
    }
    @Test
    void UpdateJobTest_5_updateJob(){}
    @Test
    void UpdateJobTest_6_updateJob(){}

}
