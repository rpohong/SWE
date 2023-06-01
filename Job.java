import java.io.BufferedReader;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Job {
    private String jobNumber;  // cond  1   "12345MMM_"
    private String jobTitle;
    private String jobPosterName;
    private String jobPosterAddress;   // cond 3   City, State, Country.
    private String jobPostedDate;      // cond 2 YYYY-MM-DD
    private String jobExperienceLevel;     // Four job experience level [ Junior, Medium, Senior, Executive ]
    //    private String[] experienceGuide    = {"Junior","Medium", "Senior", "Executive"};
    private String jobType;                // Four job types : [ Full-time, Part-time, Internship, Volunteer ]
    private static final int MAX_SIZE = 3;
    private String[] jobRequiredSkills = new String[MAX_SIZE];    // a list of skill is 1 word ( e.g., C#) or a maximum of two words e.g. Software Architecture )
    private double jobSalary;
    private String jobDescription;

    //Constructor
    public Job(String number, String title, String postername, String posteraddresss,
               String date, String experiencelevel, String type,
               String[] skills, double salary, String description) {
        // job info
        jobNumber = number;
        jobTitle = title;
        // job details
        jobPosterName = postername;
        jobPosterAddress = posteraddresss;
        jobPostedDate = date;
        // job requires
        jobExperienceLevel = experiencelevel;
        jobType = type;
        //special
        jobRequiredSkills = skills;
        // job payback
        jobSalary = salary;
        jobDescription = description;
    }

    public void setJobNumber(String JobID){this.jobNumber =JobID;}
    public String getJobNumber(){return this.jobNumber;}
    public void setJobTitle(String title){this.jobTitle =title;}
    public String getJobTitle(){return this.jobTitle;}
    public void setJobPosterName(String posterName){this.jobPosterName = posterName;}
    public String getJobPosterName(){return this.jobPosterName;}

    public void setJobPosterAddress(String address){this.jobPosterAddress = address;}
    public String getJobPosterAddress(){return this.jobPosterAddress;}
    public void setJobPostedDate(String date){this.jobPostedDate = date;}
    public String getJobPostedDate(){return this.jobPostedDate;}

    public void setJobExperienceLevel(String expLevel){this.jobExperienceLevel = expLevel;}
    public String getJobExperienceLevel(){return this.jobExperienceLevel;}
    public void setJobType(String jobType){this.jobType = jobType;}
    public String getJobType(){return this.jobType;}
    public void setJobRequiredSkills(String[] skills){
        this.jobRequiredSkills = skills;}
    public String[] getJobRequiredSkills(){
        return this.jobRequiredSkills;}
    public void setJobSalary(double salary){this.jobSalary =salary;}
    public double getJobSalary() {return this.jobSalary;}
    public void setJobDescription(String jobDescription) {this.jobDescription = jobDescription;}
    public String getJobDescription() {return jobDescription;}




    public String getInptJID(){
        Scanner scnr = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            System.out.println("Please enter your job ID ");
            String line = scnr.nextLine();
            if (line.length() == 9){
                System.out.println(line);
                return line;

            }
            else {
                System.out.println("job ID Must be 5+3+1 9 characters " +
                        "\n [5 number that in range of 0-5 ]" +
                        "\n + [3 letters ]+" +
                        "and [1 special character] "  );
            }

        }
        return scnr.nextLine();
    }


    public String getInptPosterName(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the name of job poster ");
        return scnr.nextLine();
    }
    public String getInptJobTitle(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your job title");
        return scnr.nextLine();
    }
    public String getInptJobAddress() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the address of job poster " +
                        "\nIn formatting of  City,State,Country   ");
        String address =scnr.nextLine();
        int eleCount  = 0;
        for (int i = 0; i < address.length(); i++) { // count the skills that user got
            if (address.charAt(i) == ',') {
                eleCount++;
            }}
        int gap = 2-eleCount;
        for (int i =0; i < gap; i++){
            address += ",";
        }
        return address;
    }
    public String getInptDate(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the date of job posted (in formatting of  XXXX-XX-XX)");
        return scnr.nextLine();
    }
    public String getInptExpLevel(){
        Scanner scnr = new Scanner(System.in);
        boolean ValidExpLevel = false; // job exp part
        int choice = 0;
        do {        // enter number to select
            System.out.println("Please select your experience level \n[1]Junior, [2]Medium, [3]Senior, [4]Executive]");
            if (scnr.hasNextInt()) {
                choice = scnr.nextInt();
                if (choice == 1) {return "Junior";
                } else if (choice == 2) {return "Medium";
                } else if (choice == 3) {return "Senior";
                } else if (choice == 4) {return "Executive";
                } else System.out.println("select above !");
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scnr.next(); }// Discard the invalid input
        } while (!ValidExpLevel);
        return null;
    }
    public String getInptJobType(){
        Scanner scnr = new Scanner(System.in);
        boolean ValidJobType = true;  // job type part
        int inptJobtype = 0;
        do {        // enter number to select
            System.out.println("Please select your job type \n[1]Full-time, [2]Part-time, [3]Internship, [4]Volunteer]");
            if (scnr.hasNextInt()) {
                inptJobtype = scnr.nextInt();
                if (inptJobtype == 1) {return "Full-time";
                } else if (inptJobtype == 2) {return "Part-time";
                } else if (inptJobtype == 3) {return "Internship,";
                } else if (inptJobtype == 4) {return "Volunteer";
                } else System.out.println("select above !");
            }else {
                System.out.println("Invalid input! Please enter an integer.");
                scnr.next(); }
        }while (ValidJobType) ;
        return null;
    }
//    public void setInJobRequires() {
//        Scanner scnr = new Scanner(System.in);
//        boolean ValidExpLevel = false; // job exp part
//        int choice = 0;
//        do {        // enter number to select
//            System.out.println("Please select your experience level \n[1]Junior, [2]Medium, [3]Senior, [4]Executive]");
//            if (scnr.hasNextInt()) {
//                choice = scnr.nextInt();
//                if (choice == 1) {setJobExperienceLevel("Junior");
//                    break;
//                } else if (choice == 2) {setJobExperienceLevel("Medium");
//                    break;
//                } else if (choice == 3) {setJobExperienceLevel("Senior");
//                    break;
//                } else if (choice == 4) {setJobExperienceLevel("Executive");
//                    break;
//                } else System.out.println("select above !");
//            } else {
//                System.out.println("Invalid input! Please enter an integer.");
//                scnr.next(); }// Discard the invalid input
//        } while (!ValidExpLevel);
//
//        boolean ValidJobType = true;  // job type part
//        int inptJobtype = 0;
//        do {        // enter number to select
//            System.out.println("Please select your job type \n[1]Full-time, [2]Part-time, [3]Internship, [4]Volunteer]");
//            if (scnr.hasNextInt()) {
//                inptJobtype = scnr.nextInt();
//                if (inptJobtype == 1) {setJobType("Full-time");
//                    break;
//                } else if (inptJobtype == 2) {setJobType("Part-time");
//                    break;
//                } else if (inptJobtype == 3) {setJobType("Internship,");
//                    break;
//                } else if (inptJobtype == 4) {setJobType("Volunteer");
//                    break;
//                } else System.out.println("select above !");
//            }else {
//                System.out.println("Invalid input! Please enter an integer.");
//                scnr.next(); }
//        }while (ValidJobType) ;
//    }
    public String getInRequiredSkills() {
        // to get the list
        // get inputs by string

        // the idea is fill the gap, that must have 3 value, where None fill the empty skills
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your skills \n" +
                "[No more than 2 words for each skill , do not give more than 3 skills]" +
                "\n[Please divide by ' , ' ]");
        String skills = scnr.nextLine();
        int skillCount  = 0;
        for (int i = 0; i < skills.length(); i++) { // count the skills that user got
            if (skills.charAt(i) == ',') {
                skillCount++;
            }
        }
        if(skillCount <MAX_SIZE){  // the value of skills must be 3
            if (skillCount == 0) {  // if there are no skills given
                skills += ",None,None";
            }
            int gap = MAX_SIZE - skillCount; // if there are no enough skills given
            for (int i = 1 ; i < gap; i++){
                skills += ",None";      // fill the space with None
            }
        }
        return  skills;  // transfer to list and set inside
    }

//    public void setInptSalary(){
//        Scanner scnr = new Scanner(System.in);
//        boolean conditions = true;
//         do {
//             System.out.println("Please enter the salary" +
//                        "\nBe care that Senior and Executive should above 100,000" +
//                        "\nJunior jobs should be between 40000 and 70000." );
//            if (scnr.hasNextDouble()){
//                double d = scnr.nextDouble();
//                setJobSalary(d);
//                break;}
//            else{
//                System.out.println("Numbers please");
//                scnr.next();
//            }
//        }while (conditions);
//
//    }

    public double getInptSalary(){
        Scanner scnr = new Scanner(System.in);
        boolean conditions = true;
        do {
            System.out.println("Please enter the salary" +
                    "\nBe care that Senior and Executive should above 100,000" +
                    "\nJunior jobs should be between 40000 and 70000." );
            if (scnr.hasNextDouble()){
                double d = scnr.nextDouble();
                return d;
                }
            else{
                System.out.println("Numbers please");
                scnr.next();
            }
        }while (conditions);
        return 0.0;
    }

    public void setAllInputs(){
        Scanner scnr = new Scanner(System.in);
        setJobNumber(getInptJID()); //JID
        setJobTitle(getInptJobTitle()); // J title
        setJobPosterName(getInptPosterName());  //J P-name
        setJobPosterAddress(getInptJobAddress());  //J Address
        setJobPostedDate(getInptDate());        // Date

        setJobExperienceLevel(getInptExpLevel());  // exp level
        setJobType(getInptJobType());//  type

        setJobRequiredSkills(transToList(getInRequiredSkills()));   //get skills();
        setJobSalary(getInptSalary());  // salary
        System.out.println("Please enter the job descriptions "); // desc
        setJobDescription(scnr.nextLine());
    }
    public boolean addJob() {
//        ( not in the formatting of ( 1-5 for first 5 characters/ letter for following 3 characters / symbol for last character)
//      condition 1 12345mmm_  (job Number)
        if (!C1jobID(jobNumber)) {
//            System.out.println("Not in correct Job ID formatting");
            return false;   //if not in the formatting
        }
//      condition 2 YYYY-MM-DD   (job post date)
        if (!C2Dates(jobPostedDate)) {
            return false;   //if not matching
        }
////      City, State, Country. Example: Melbourne, Victoria, Australia.
        if (!C3Address(jobPosterAddress)) {
            return false;
        }
//     condition 4.     Senior and Executive
//                      100,000  <=   salary
//      condition 5     Junior ==>  40000 - 70000.
////                    [ Junior, Medium, <Senior, Executive> ]
        if (!C4_5JobExp(jobExperienceLevel, jobSalary)) {
            return false;
        }
//        new Job ("12345mmm_","A",
//                "B","City,state,country",
//                "2023-12-05", "Medium","50000",
//                new String[]{"skills"},12,"G");
        if (!C6_PtJob(jobExperienceLevel,jobType)){
            return false;
        }
        if (!C7_Skills(jobRequiredSkills)){
            return false;
        }
        return true;

    }
    public void updateAndSet(){ //set all info that found
        Scanner scnr = new Scanner(System.in);
        System.out.println("please enter the JobID that need to update");
        String JID = scnr.nextLine(); // get the JID
        String line = findString(JID); // the entire strings in file

        String[] items = transToList(line);

        setJobNumber(items[0]); //ID
        setJobTitle(items[1]);
        setJobPosterName(items[2]);

        setJobPosterAddress(items[3]+"-"+items[4]+"-"+items[5]);

        setJobPostedDate(items[6]);
        setJobExperienceLevel(items[7]);
        setJobType(items[8]);

        String[] skills = {items[9],items[10],items[11]};
        setJobRequiredSkills(skills);

        double salary = Double.parseDouble(items[12]);
        setJobSalary(salary);

        setJobDescription(items[13]);

    }

    public void getNewinputs(){
        Scanner scnr = new Scanner(System.in);
        boolean condition =true;
        int choice;
        System.out.println("Please enter the new updates" +
                "\n[current file is "+ getJobNumber()+ " \". ");
        do {
            String newJobType ="";
            String jobexplevel="";
            double newSalary = 0.0;
            System.out.println(
                    "\n1.update Job title" +
                    "\n2.update Job poster name" +
                    "\n3.update Job address" +
                    "\n4.update Job Date" +
                    "\n5.update Job experience level" +
                    "\n6.update Job type" +
                    "\n7.update Job Skills" +
                    "\n8.update Job Salary" +
                    "\n9.update Job Description" +
                    "\n0.updating finished !");
            if (scnr.hasNextInt()) {
                choice = scnr.nextInt();
                if (choice == 1) {
                    setJobTitle(getInptJobTitle());
                } else if (choice == 2) {
                    setJobPosterName(getInptPosterName());
                } else if (choice == 3) {
                    setJobPosterAddress(getInptJobAddress());
                } else if (choice == 4) {
                    setJobPostedDate(getInptDate());
                }else if (choice == 5) {
                    setJobExperienceLevel(getInptExpLevel());
                }else if (choice == 6) {
                    newJobType= getInptJobType();
                    if (getJobType().equalsIgnoreCase("Full-time")){
                        if (newJobType.equalsIgnoreCase("Part-time") //  Full-time  =/=>Part-time or Volunteer
                                ||newJobType.equalsIgnoreCase("Volunteer")){
                            System.out.println("Full-time jobs can not be changed to Part-time or Volunteer jobs");
                        }else {
                        setJobType(newJobType);}
                    }
                }else if (choice == 7) {
                    setJobRequiredSkills(transToList(getInRequiredSkills()));
                }else if (choice == 8) {
                    newSalary = getInptSalary();
                    if (getJobExperienceLevel().equalsIgnoreCase("Junior")){
                        double upperlimite = getJobSalary()* (1+0.1);
                        if(getInptSalary()> upperlimite){
                            System.out.println("\nthe salary of Junior jobs should not be increased by more than 10%.");

                        }
                    }else {
                        double increaseLimit_low = getJobSalary()* (1+0.2);
                        double increaseLimit_high = getJobSalary()* (1+0.4);
                        if (newSalary < increaseLimit_high && newSalary > increaseLimit_low) {
                            setJobSalary(newSalary);
                        }
                        System.out.println("The salary of all jobs except Junior jobs can be increased by between 20% and 40%");
                    }
                }else if (choice == 9) {
                    System.out.println("Please enter the job descriptions "); // desc
                    setJobDescription(scnr.nextLine());
                }else if (choice == 0) {
                    condition = false;
                    break;
                } else System.out.println("select one above !");
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scnr.next();
            }// Discard the invalid input
        }while (condition);

    }
    public static void removeLineFromFile(String JID)  { // delete specific line
        String file = "items.txt";
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = reader.readLine()) != null) {
                if (!line.trim().startsWith(JID)) {
                    writer.println(line);
                    writer.flush();
                }
            }
            writer.close();
            reader.close();
            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean updateJob() {
        //  Update the information of a given job in a TXT file
        //  if the job's new information meets the defined conditions,
        //  the job information should be updated in the TXT file
        //  if the job's new information does not meet the following conditions,
        //  the job information should not be updated in the TXT file and the function should return false.

//        Scanner scnr = new Scanner(System.in);
//        updateAndSet(); // get the string and set up
//        getNewinputs();
//        if (!addJob()){
//            System.out.println("new data not accepted");
//            return false;}


        String[] originalStr = originalString();  // the old ver of string

        if (!addJob()){  // if data accepted
            return false;
        }
        if (!updateCo2Junior(originalStr)){
            return false;
        }
        if (!updateCo2Else(originalStr)){
            return false;
        }
        if (!updateCo3JobType(originalStr)){
            return false;
        }



        String fin = getAll();

        return true;

    }



    public  boolean UpdateCod2(){

        String fileString = findString(getJobNumber()); // the string in file
        String[] originalStr = transToList(fileString);

        System.out.println("file liness=================");
        for(int i = 0;i<originalStr.length;i++) {
            System.out.println(originalStr[i]);
        }

        return true;
    }

// finding in file ly JID
    public static String findString(String JID){

        String finLine = "404";  // if target not found

        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(JID)) { // if found
                    finLine = line;
//                    System.out.println(line);
                    return line;

                }
            }
        } catch (IOException e) {  // error catch
            e.printStackTrace();
        }
        System.out.println("target ID string not found !"+ JID);
        return finLine;
    }


// used for Add job part
    // condition 1
    public static boolean C1jobID(String jobID) {
        String firstFive = jobID.substring(0, Math.min(jobID.length(), 5));
        String nextThree = jobID.substring(5, Math.min(jobID.length(), 8));
        String Special =    jobID.substring(8, Math.min(jobID.length(), 9));

        if (jobID.length() != 9 ) {
            return false;
        }if (!firstFive.matches("[0-5]+")){
            return false;
        }else if (!nextThree.matches("[a-zA-Z]+")){
            return false;
        }else if (Special.matches("[0-9]" ) ||Special.matches("[a-zA-Z]" )) {
            return false;
        }return true;

    }
    public static boolean C2Dates(String date) {
        if (isValidDateFormat(date)) {
            if (C2_LeapingDates(date)) {
                return true;
            }
            return false;
        }
        return false;
    }
    public static boolean C2_LeapingDates(String date) {
//      YYYY-MM-DD  have 10 character long
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] Date = date.split("-", 3);     //String[] Year = new String[]{date.split("-", 3)[0]};
//        for (String a : Date)
//            System.out.println(a);

        int year = Integer.parseInt(Date[0]);
        int month = Integer.parseInt(Date[1]);
        int day = Integer.parseInt(Date[2]);

        //2. checking leap year by February test
//        System.out.println("Feb ?");
//        System.out.println(leapYear(year, month, day));
//        System.out.println("30 ?");
//        System.out.println(month_30(month,day));
//        System.out.println("31?");
//        System.out.println(month_31(month,day));
//        System.out.println("========");

        if (leapYear(year, month, day) || month_30(month, day) || month_31(month, day)) {
            return true;
        }
        return false;
    }
    public static boolean leapYear(int year, int month, int day) {
        if (month == 2) {
            // the leap year
            if (!(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
                if (0 <= day && day <= 28) {     // System.out.println("not a leap year ");
                    return true;
                }
            } else {
                if (0 <= day && day <= 29) {     // System.out.println("Leap year ");
                    return true;
                }
            }
        }
        return false;

    }
    public static boolean month_31(int month, int day) {
        if (month == 1
                || month == 3
                || month == 5
                || month == 7
                || month == 8
                || month == 10
                || month == 12) {
            if (0 <= day && day <= 31) {
//                System.out.println("31 days month true ");
                return true;
            } else {
//                System.out.println("date input error");
                return false;
            }
        }
        // not 31 days month or error inputs
        return false;
    }
    public static boolean month_30(int month, int day) {
        if (month == 4
                || month == 6
                || month == 9
                || month == 11
        ) {
            if (0 <= day && day <= 30) {
//                System.out.println("30 days month true ");
                return true;
            } else {
//                System.out.println("date input error");
                return false;
            }
        }
        // not 30 days month or error inputs
        return false;
    }
    public static boolean isValidDateFormat(String date) { // for dates
        if (date.length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-') {
            System.out.println("formatting");
            return false;
        }
        if (!date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return false;
        }
        return true;
    }
    // condition 3 City, State, Country. Example: Melbourne, Victoria, Australia.
    public static boolean C3Address(String inptAddress) {
        // ^ = start  /   [^,] = not , character / \\.$ = a "." at end
//        if (inptAddress.matches("^[^,]+,[^,]+,[^,]+\\.$")) {
//            return true;
//        }
//        return false;

        if (inptAddress.endsWith(".")) {    // ignore the "." at end
            inptAddress = inptAddress.substring(0, inptAddress.length() - 1);
        }
        //1. split back to array
        String[] addresses = inptAddress.split(",\\s*") ;  // unsure the ending
        //2. count skills
        if (! (addresses.length == 3)) {
            return false;   // out of count
        }
        return true;
    }
// Condition 4 & 5
// [ Junior, Medium] ==> { 40,000 - 70,000 }
// Senior, Executive ==> { >10,000 }]
    public static boolean C4_5JobExp(String inptExp, double salary) {

        if (inptExp.equalsIgnoreCase("Junior")
//                || inptExp.equalsIgnoreCase("Medium")
        ) {
            if (40000.0 <= salary && salary <= 70000.0) {
                return true;
            }
        } else if (inptExp.equalsIgnoreCase("Senior")
                || inptExp.equalsIgnoreCase("Executive")
        ) {
            if (100000.0 <= salary) {
                return true;
            }
        }
        return false;
    }
//condition 6 Part-time jobs cannot be at Senior or Executive levels.
    public static boolean C6_PtJob(String inptExp, String type){
         if (type.equalsIgnoreCase("Part-time")){
                 if( inptExp.equalsIgnoreCase("Senior")
                 || inptExp.equalsIgnoreCase("Executive")){
                 return false;
             }
        }        return true;
    }
// condition 7
    public static boolean C7_Skills(String[] skillList) {
        // convert to string
        String inpt_skill = String.join(", ", skillList);
        // ignore the "." at end
        if (inpt_skill.endsWith(".")) {
            inpt_skill = inpt_skill.substring(0, inpt_skill.length() - 1);
        }
        //1. split back to array
        String[] skills = inpt_skill.split(",\\s*") ;
        //2. count skills
        if (!(skills.length > 0 && skills.length <= 3)) {
            return false;   // out of count
        }
        //3. count words
        for (String skill : skills) {
            if (skill.split("\\s+").length > 2) {
                return false;  // out of words
            }
        }return true;
    }
    public static boolean VerifyString(String JID){
        String finLine = "404";  // if target not found

        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (transToList(line)[0].equals(JID)){
                    finLine = line;
                    return true;
//                    System.out.println(line);
                }

            }
        } catch (IOException e) {  // error catch
            e.printStackTrace();
        }
        return false;
    }


    public String[] originalString(){

        String fileString = findString(getJobNumber()); // the string in file

        System.out.println(fileString);
        String[] originalStr = transToList(fileString);
//        for(int i = 0;i<originalStr.length;i++) {
//            System.out.println(originalStr[i]+"==");
//        }
//        System.out.println(addJob());
        return originalStr;
    }

    public boolean updateCo3JobType(String[] fileString){
        // Full-time  =/=>Part-time or Volunteer
        String[] orgStr = fileString;
        String orgJobType = fileString[7];
        if (orgJobType.equalsIgnoreCase("Full-time")){  // if original were Full-time
            if (getJobType().equalsIgnoreCase("Part-time") //  if new inputs is Part-time or Volunteer
                    ||getJobType().equalsIgnoreCase("Volunteer")){
                return false;
            }
        }
        return true;
    }
    public boolean updateCo2Junior(String[] fileString){
        Scanner scan =new Scanner(System.in);
        // Junior + (<10%)
//        System.out.println(findString(getJobNumber()));
        String[] orgStr = transToList(findString(getJobNumber()));

//        System.out.println(orgStr[13]);


        double orgSalary = Double.parseDouble(orgStr[13].replace(",",""));
        double upperlimite = orgSalary* (1.1);


        System.out.println(getJobSalary()+"<"+upperlimite);
        System.out.println((getJobSalary()<=upperlimite));
        if (orgStr[7].equalsIgnoreCase("Junior".replace(",",""))){
            if(getJobSalary()<=upperlimite){  // inside of range
                return true;}
        } //the salary of Junior jobs should not be increased by more than 10%.

        System.out.println("acturally = "+ getJobSalary()+ " which should be below than"+upperlimite);
        return false;
    }


    public boolean updateCo2Else(String[] fileString){
        // rest + ( 20% - 40%)
        String[] orgStr = fileString;
        double orgSalary = Double.parseDouble(fileString[13].replace(",",""));
        double increaseLimit_low = orgSalary* (1+0.2);
        double increaseLimit_high = orgSalary* (1+0.4);
        if (!(fileString[7].equalsIgnoreCase("Junior"))){// when not Junior
            if (getJobSalary() > increaseLimit_high && getJobSalary() < increaseLimit_low) {
                // new > 20%+  and new < 40%+
                return true;
            } //"The salary of all jobs except Junior jobs can be increased by between 20% and 40%"
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
//      TODO Auto-generated method stub
/**
    Job job = new Job("12345mmm_", "A", "B",
            "C", "D", "E", "F",
            array, 12, "G");

        String address = "0,goiq3bq qb8c    2 TC w,7.";
        System.out.println(C3Address(address));

        condition 4. salary <= 100,000
        [ Junior, Medium, <Senior, Executive> ]
        String expLevel = "Senior";
        int salary = 535401;
        System.out.println(C4_5JobExp(expLevel,salary));
        String skills ="C #, SQ L, 12ewnioiw wfhowh  .";
        System.out.println(C7_Skills(array));

        System.out.println(C3Address(address));

        boolean x;
        if (!C3Address(address)) {
            x = false;
        }x = true;
        System.out.println(x);

        Part-time jobs cannot be at Senior or Executive
        String type = "Part-time";
        String exp =  "Executive";
        System.out.println(C6_PtJob(exp,type));
*/

        int selection = 0;
        boolean prog =true;


//        Job job = new Job("12345mmm_", "A",
//                "B", "City,State,Country",
//                "YYYY-MM-DD", "E",
//                "Volunteer", new String[]{"skill 1,skill 2,skill 3"},
//                12, "G");

        Job job = new Job("12345mmm_","Book Title","Poster Name","Melbourne,Victoria,Australia",
                "2012-01-01", "Senior","F",new String[]{"Skill 1","Skill 2","None"},100000,"G");


        System.out.println("=======");
        System.out.println(findString(job.getJobNumber()));
        System.out.println("=======");

        String[] originalStr = job.originalString();
        System.out.println("\ncompareing");

        // job type
//        String newJobType = originalStr[7];
        String orgJobType ="Full-time";
        System.out.println("the original "+orgJobType);
        System.out.println("the new "+job.getJobType());


        System.out.println("after changes");
        System.out.println(job.getJobType());




//            String fileString = findString(job.getJobNumber()); // the string in file
//            String[] originalStr = transToList(fileString);
//            for(int i = 0;i<originalStr.length;i++) {
//                System.out.println(originalStr[i]);
//            }
//            System.out.println(job.addJob());



        System.out.println("================================");
        do {  // clear the current value by default
            selection = menu(); // display menus
            while (selection != 0) {
                if (selection == 1) { // add job selection
                    String fin = "";  // the final string
                    job.setAllInputs(); // get and set the new information

                    // System.out.println("Setting data ...");
                    // collect all information
                    fin = job.getAll();
                    if (VerifyString(job.getInptJID())){ // check the repeating in file
                        System.out.println("the Job ID already in file !");
                        break;
                    }
                    System.out.println(fin);
                    if (job.addJob()) { // if verification passed
                        addIn(fin);      // get final string to upload
                        System.out.println("done");
                    }
                    break;
                } else if (selection == 2) {
                    if (job.updateJob()){
                        removeLineFromFile(job.getJobNumber());// remove original line from file
                        String finalStr = job.getAll(); // get new string
                        addIn(finalStr);    // add into the file
                    }
                    break;
                }
                else if (selection == 0){
                    prog = false;
                    break;
                }
            }
        }while (prog);
        System.out.println("thanks for using ");
        System.exit(0);
    }

    public static int menu(){
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        int choice = 0;
        do {
            System.out.println("=== Menu ===");
            System.out.println(
                    "\n[1] Add a new job" +
                    "\n[2] Update a current job " +
                    "\n[0] Exit"+
                    "\nPleases select the option");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice ==1 ||choice ==2)
                    return choice;
                else if (choice ==0 ){
                    System.out.println("close the system ...");
                    System.exit(0);
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Discard the invalid input
            }
        }while (!isValidInput);
        return 0;
    }

    public String getAll(){
        String fin = getJobNumber() +","+ getJobTitle()+","+
                getJobPosterName()+","+ getJobPosterAddress()+","+
                getJobPostedDate()+","+ getJobExperienceLevel()+","+
                getJobType()+","+ transToString(getJobRequiredSkills())+"," +
                getJobSalary()+","+getJobDescription();
        return fin;
    }

    public static String transToString(String[] inpt){  // transfer a list into one String line
        String line = "";
        for (int i = 0;i < inpt.length;i++){
            if (i!=0) {
                line += "," + inpt[i];
            }else {
            line +=inpt[i];}
        }
        return line;
    }
    public static String[] transToList(String inpt){    // transfer a String into a list
        String[] list = inpt.split(",",14);
        return list;
    }

    public static void addIn(String finalString){       //add the result to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt",true))) {
            writer.newLine();
            writer.write(finalString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
