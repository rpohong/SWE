import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class addJobTest {

// public Job (String number,
//              String title,
//              String postername,
//              String posteraddresss,
//              String date,
//              String experiencelevel,
//              String type,
//              String [] skills,
//              double salary,
//              String description)

    @Test
    void testAddJob_1_ValidInputs(){
        Job addJobTest1_1Valid = new Job ("32224RMI^","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Senior","F",new String[]{"Skill 1","Skill 2","None"},100000,"G");
        Job addJobTest1_2Valid =new Job ("12345mmm_","A","B","New York,state,USA",
                "2023-12-05", "Senior","F",new String[]{"skills 1","Skills 2","Skills 3"},100000,"G");
        assertAll("",
                ()->assertEquals(true,addJobTest1_1Valid.addJob()),
                ()->assertEquals(true,addJobTest1_2Valid.addJob())
        );

    }

    @Test
    // job ID
    void testAddJob_2_jobID(){
//  Condition 1. Job ID == 9 characters
//  [1-5] X 5 + Letter X3 + special X 1
//  e.g. "12345MMM_"
        //test Data 1 correct input
        Job addJobTest2_1Valid = new Job ("12345mmm_","A","B","City,state,country",
                "2023-12-05", "Senior","F",new String[]{"skills 1","Skills 2","Skills 3"},100000,"G");
        Job addJobTest2_2Valid = new Job ("55555TTT^","A","B","City,state,country",
                "2023-12-05","Senior","F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");
        assertAll("",

                ()->assertEquals(true,addJobTest2_1Valid.addJob()),

                ()->assertEquals(true,addJobTest2_2Valid.addJob())
                );
    }

    @Test
    void testAddJob_3_Date(){
        //Condition 2. jobPostedDate  format:
        // YYYY-MM-DD. Example: 2023-02-05

        Job addJobTest3_1Valid = new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05",
                "Senior","F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");

        //"xxxx-xx-xx"
        Job addJobTest3_2Valid = new Job("12345mmm_","A","B",
                "City,state,country", "2001-02-21",
                "Senior","F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");

        assertAll("",
                ()->assertEquals(true,addJobTest3_1Valid.addJob()),
                ()->assertEquals(true,addJobTest3_2Valid.addJob())
                );
    }

    @Test
    void testAddJob_4_Address(){
        //condition 3    City, State, Country. Example: Melbourne, Victoria, Australia.

        Job addJobTest4_1Valid = new Job("12345mmm_","A","B",
                "BengBu,AnHui,China", "2023-12-05","Senior",
                "F",new  String[]{"skills 1","Skills 2","Skills 3"},120000,"G");

        Job addJobTest4_2valid = new Job("12345mmm_","A","B",
                "Melbourne,Victoria,Australia ", "2023-12-05","Senior",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");

        assertAll("",
                ()->assertEquals(true,addJobTest4_1Valid.addJob()),
                ()->assertEquals(true,addJobTest4_2valid.addJob())
                );

    }

    @Test
    void testAddJob_5_JuniorSalary(){

        Job addJobTest5_1Valid = new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Junior",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},40000,"G");
        Job addJobTest5_2InValid = new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Junior",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");

        assertAll("",
                ()->assertEquals(true,addJobTest5_1Valid.addJob()),
                ()->assertEquals(false,addJobTest5_2InValid.addJob())
        );
    }
    @Test
    void testAddJob_6_HighSalary(){

        Job addJobTest6_1Valid = new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Senior",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");
        Job addJobTest6_2Valid = new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Executive",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},100000,"G");

        assertAll("",
                ()->assertEquals(true,addJobTest6_1Valid.addJob()),
                ()->assertEquals(true,addJobTest6_2Valid.addJob())
        );
    }
    @Test
    void testAddJob_7_Skills(){
        Job addJobTest7_1Valid =new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Senior",
                "F", new String[]{"skills1","Skills2","Skills3"},120000,"G");
        Job addJobTest7_2Valid =new Job("12345mmm_","A","B",
                "City,state,country", "2023-12-05","Senior",
                "F", new String[]{"skills 1","Skills 2","Skills 3"},120000,"G");
        assertAll("",
                ()->assertEquals(true,addJobTest7_1Valid.addJob()),
                ()->assertEquals(true,addJobTest7_2Valid.addJob())
        );
    }

}

