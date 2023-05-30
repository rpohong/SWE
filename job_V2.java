import java.io.BufferedReader;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


    public  void setInJobInfo(){    // get JobNumber(ID) & title
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your job ID ");
        setJobNumber(scnr.nextLine());
        System.out.println("Please enter your job title");
        setJobTitle(scnr.nextLine());

    }
    public void setInJobDetails() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter the name of job poster ");
        setJobPosterName(scnr.nextLine());
        System.out.println("Please enter the address of job poster ");
        String address =scnr.nextLine();
        int eleCount  = 0;
        for (int i = 0; i < address.length(); i++) { // count the skills that user got
            if (address.charAt(i) == ',') {
                eleCount++;
            }}
        int gap = 2-eleCount;
        if (gap >=0){
            address +=",";
        }

        setJobPosterAddress(scnr.nextLine());
        System.out.println("Please enter the date of job posted (in formatting of  XXXX-XX-XX)");
        setJobPostedDate(scnr.nextLine());
    }
    public void setInJobRequires() {
        Scanner scnr = new Scanner(System.in);
        boolean ValidExpLevel = false; // job exp part
        int choice = 0;
        do {        // enter number to select
            System.out.println("Please select your experience level \n[1]Junior, [2]Medium, [3]Senior, [4]Executive]");
            if (scnr.hasNextInt()) {
                choice = scnr.nextInt();
                if (choice == 1) {setJobExperienceLevel("Junior");
                    break;
                } else if (choice == 2) {setJobExperienceLevel("Medium");
                    break;
                } else if (choice == 3) {setJobExperienceLevel("Senior");
                    break;
                } else if (choice == 4) {setJobExperienceLevel("Executive");
                    break;
                } else System.out.println("select above !");
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scnr.next(); }// Discard the invalid input
        } while (!ValidExpLevel);

        boolean ValidJobType = true;  // job type part
        int inptJobtype = 0;
        do {        // enter number to select
            System.out.println("Please select your job type \n[1]Full-time, [2]Part-time, [3]Internship, [4]Volunteer]");
            if (scnr.hasNextInt()) {
                inptJobtype = scnr.nextInt();
                if (inptJobtype == 1) {setJobType("Full-time");
                    break;
                } else if (inptJobtype == 2) {setJobType("Part-time");
                    break;
                } else if (inptJobtype == 3) {setJobType("Internship,");
                    break;
                } else if (inptJobtype == 4) {setJobType("Volunteer");
                    break;
                } else System.out.println("select above !");
            }else {
                System.out.println("Invalid input! Please enter an integer.");
                scnr.next(); }
        }while (ValidJobType) ;
    }
    public void setInRequiredSkills() {  // to get the list
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
                skills += "None";
            }
            int gap = MAX_SIZE - skillCount; // if there are no enough skills given
            for (int i = 1 ; i < gap; i++){
                skills += ",None";      // fill the space with None
            }
        }
        setJobRequiredSkills(transToList(skills));  // transfer to list and set inside
    }

    public void setInRestinfo(){
        Scanner scnr = new Scanner(System.in);
        boolean conditions = false;
         do {
             System.out.println("Please enter the address of job poster " +
                 "\nBe care that Senior and Executive should above 100,000" +
                 "\nJunior jobs should be between 40000 and 70000." );
            if (scnr.hasNextDouble()){
                double d = scnr.nextDouble();
                setJobSalary(d);
                break;}
            else{
                System.out.println("Numbers please");
            }
        }while (!conditions);

        System.out.println("lease enter the job descriptions ");
        setJobDescription(scnr.nextLine());
    }

    public void setAllInputs(){
        setInJobInfo();
        setInJobDetails();
        setInJobRequires();
        setInRequiredSkills();
        setInRestinfo();

    }
    public boolean addJob() {
//        ( not in the formatting of ( 1-5 for first 5 characters/ letter for following 3 characters / symbol for last character)
//      condition 1 12345mmm_  (job Number)
        if (!C1jobID(jobNumber)) {
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
        if (!C6_PtJob(jobExperienceLevel,jobType))
        if (!C7_Skills(jobRequiredSkills)){
            return false;
        }

        return true;


    }

    public boolean updateJob() {
        addJob();
        String line = findString();

        if (line.length() > 5){
        }

        //  Update the information of a given job in a TXT file
        //  if the job's new information meets the defined conditions,
        //  the job information should be updated in the TXT file
        //  if the job's new information does not meet the following conditions,
        //  the job information should not be updated in the TXT file and the function should return false.


        return true;

    }


    public static void addIntoFile(String fin){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt",true))) {
            writer.newLine();
            writer.write(fin);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String findString(){
        Scanner scnr = new Scanner(System.in);

        System.out.println("please enter the JobID that need to update");
        String inpt = '"'+scnr.nextLine();
//        if (!C1jobID(inpt)){
//            System.out.println("invalid formatting!");
//            return null;
//        }
        String finLine = "404";  // if target not found
        System.out.println("======");
        try (BufferedReader reader = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(inpt)) { // if found
                    finLine = line;
//                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {  // error catch
            e.printStackTrace();
        }
        return finLine;
    }

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



    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

////      TODO Auto-generated method stub
//        String[] array = {"C #"," SQ L"," 12ewnioiw wfhowh ." };
////    Job job = new Job("12345mmm_", "A", "B",
////            "C", "D", "E", "F",
////            array, 12, "G");
//
////        String address = "0,goiq3bq qb8c    2 TC w,7.";
////        System.out.println(C3Address(address));
//
//////      condition 4. salary <= 100,000
//////      [ Junior, Medium, <Senior, Executive> ]
////        String expLevel = "Senior";
////        int salary = 535401;
////        System.out.println(C4_5JobExp(expLevel,salary));
//        String skills ="C #, SQ L, 12ewnioiw wfhowh  .";
//        System.out.println(C7_Skills(array));

//        System.out.println(C3Address(address));

//        boolean x;
//        if (!C3Address(address)) {
//            x = false;
//        }x = true;
//        System.out.println(x);

//        Part-time jobs cannot be at Senior or Executive
//        String type = "Part-time";
//        String exp =  "Executive";
//        System.out.println(C6_PtJob(exp,type));

        boolean prog =true;
        do {
            Job job = new Job("12345mmm_", "A",
                    "B", "C",
                    "D", "E",
                    "F", new String[]{"skills"},
                    12, "G");

            boolean invalidChoice;
            int selection = 0;
            selection = menu();
            while (selection != 0) {
                if (selection == 1) { // add job selection
                    String fin = "";  // the final string
                    job.setAllInputs();
                    if (job.addJob()) {
                        fin = finalString(); // get final string to upload
                        addIn(fin);     //upload
                    }
                    System.out.println(" ? ");
                    break;
                } else if (selection == 2) {
                    job.updateJob();
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





//            System.out.println("You entered: " + choice);
//            case 1 :
//                // Option 1 logic
//                System.out.println("AddJob selected");
//                return choice;
//            case 2 :
//                // Option 2 logic
//                System.out.println("Update selected");
//                return choice;
//            default :
//                System.out.println("Invalid choice. Please try again.");
















//        System.out.println(transToString(job.getJobRequiredSkills())) ;


//        String str ="Apple, Banana, Orange";
//        String[] list = transToList(str);
//        for (String i: list){
//            System.out.println(i);
//        }

//        String fin = job.getJobNumber() + job.getJobTitle()+ job.getJobPosterName()+ job.getJobPosterAddress()+
//                job.getJobPostedDate()+ job.getJobExperienceLevel()+ job.getJobType()+
//                transToString(job.getJobRequiredSkills())
//                + job.getJobSalary()+ job.getJobDescription();
//        writeIn(fin);

//        List<String> values = new ArrayList<>();
//        values.add(job.getJobNumber());
//        values.add(job.getJobTitle());
//        values.add(job.getJobPosterName());
//        values.add(job.getJobPosterAddress());
//        values.add( job.getJobPostedDate());
//        values.add(job.getJobExperienceLevel());
//        values.add(job.getJobType());
//        values.add(transToString(job.getJobRequiredSkills()));
//        values.add(String.valueOf(job.getJobSalary()));
//        values.add(job.getJobDescription());
//
//        System.out.println(values);
//        String combinedString = "\"" + String.join("\", \"", values) + "\"";
//        System.out.println(combinedString);
//        addIn(combinedString);

//        finalString(get);



    }
    public static int inptInt() {

        while (true) {
            System.out.print("Please enter an integer: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Discard the invalid input
            }
        }
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

    public static String finalString(){
        List<String> values = new ArrayList<>();
        Job job = null;
        values.add((String) job.getJobNumber());
        values.add(job.getJobTitle());
        values.add(job.getJobPosterName());
        values.add(job.getJobPosterAddress());
        values.add( job.getJobPostedDate());
        values.add(job.getJobExperienceLevel());
        values.add(job.getJobType());
        values.add(transToString(job.getJobRequiredSkills()));
        values.add(String.valueOf(job.getJobSalary()));
        values.add(job.getJobDescription());
//        String fin = job.getJobNumber() + job.getJobTitle()+ job.getJobPosterName()+ job.getJobPosterAddress()+
//                job.getJobPostedDate()+ job.getJobExperienceLevel()+ job.getJobType()+
//                transToString(job.getJobRequiredSkills())
//                + job.getJobSalary()+ job.getJobDescription();
        System.out.println(values);
        String combinedString = "\"" + String.join("\", \"", values) + "\"";
        System.out.println(combinedString);
        return combinedString;

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
        String[] list = inpt.split(",");
        return list;
    }

    public static void addIn(String finalString){       //add the result to the file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("items.txt"))) {
            writer.newLine();
            writer.write("\"" + String.join("\", \"", finalString) + "\"");  // add the """"

        } catch (IOException e) {
            e.printStackTrace();

        }
    }






// [ Junior, Medium] ==> { 40,000 - 70,000 }//
// Senior, Executive ==> { >10,000 }]
//    public static boolean JobExp(String inptExp, int salary){
//
//        if (inptExp.equalsIgnoreCase("Junior")
//                ||inptExp.equalsIgnoreCase("Medium")
//        ) {
//            if (40000<=salary && salary<=70000){
//                return true;}
//        }else if (inptExp.equalsIgnoreCase("Senior")
//                ||inptExp.equalsIgnoreCase("Executive")
//        ){
//                if  (100000<= salary)  {
//                    return true;}
//        }
//        return false;
//    }


}
