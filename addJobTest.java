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
    // job ID
    void testAddJob_testCase1(){
//  Condition 1. Job ID == 9 characters
//  [1-5] X 5 + Letter X3 + special X 1
//  e.g. "12345MMM_"
        System.out.println("test case 1 ");;

        //test Data 1 correct input
        Job addJobTestCase1Data1 = new Job ("12345mmm_","A","B","C",
                "2023-12-05", "E","F",new String[]{"skills"},12,"G");

        Job addJobTestCase1Data2 = new Job ("12345mmmm_","A","B","C",
                "20xxxxx","E","F", new String[]{"skills"},12,"G");

        assertAll("",

                ()->assertEquals(true,addJobTestCase1Data1.addJob()),

                ()->assertEquals(false,addJobTestCase1Data2.addJob())
                );


    }

    @Test
    void testAddJob_testCase2(){
        //Condition 2. jobPostedDate  format:
        // YYYY-MM-DD. Example: 2023-02-05
        System.out.println("test case 2");
        Job addJobTestCase2Data1 = new Job("12345mmm_","A","B","C",
                "2023-12-05","E","F", new String[]{"skills"},12,"G");

        //"xxxx-xx-xx"
        Job addJobTestCase2Data2 = new Job("12345mmm_","A","B","C",
                "2001-02-29","E","F", new String[]{"skills"},12,"G");


        assertAll("",
                ()->assertEquals(true,addJobTestCase2Data1.addJob()),


                ()->assertEquals(false,addJobTestCase2Data2.addJob())
                );

        System.out.println(" test case 2 fin");

    }

}
