import java.time.format.DateTimeFormatter;


public class Job {
    private String jobNumber;  // cond  1   "12345MMM_"
    private String jobTitle;
    private String jobPosterName;
    private String jobPosterAddress;   // cond 3   City, State, Country.
    private String jobPostedDate;      // cond 2 YYYY-MM-DD
    private String jobExperienceLevel;     // Four job experience level [ Junior, Medium, Senior, Executive ]
    private String jobType;                // Four job types : [ Full-time, Part-time, Internship, Volunteer ]
    private String[] jobRequiredSkills;    // a list of skill is 1 word ( e.g., C#) or a maximum of two words e.g. Software Architecture )
    private double jobSalary;
    private String jobDescription;

    //Constructor
    public Job(String number, String title, String postername, String posteraddresss,
               String date, String experiencelevel, String type,
               String[] skills, double salary, String description) {
        jobNumber = number;
        jobTitle = title;
        jobPosterName = postername;
        jobPosterAddress = posteraddresss;
        jobPostedDate = date;
        jobExperienceLevel = experiencelevel;
        jobType = type;
        jobRequiredSkills = skills;
        jobSalary = salary;
        jobDescription = description;
    }


    public boolean addJob() {


//        ( not in the formatting of ( 1-5 for first 5 characters/ letter for following 3 characters / symbol for last character)
//      condition 1 12345mmm_  (job Number)
        if ((jobNumber.length() != 9) && !jobNumber.matches("[1-5]{5}[A-Z]{3}_")) {
            return false;   //if not in the formatting
        }


//      condition 2 YYYY-MM-DD   (job post date)
        if ( ! C2Dates(jobPostedDate)){
            return false;   //if not matching
        }







        return true;

    }

    public boolean updateJob() {


        //  Update the information of a given job in a TXT file
        //  if the job's new information meets the defined conditions,
        //  the job information should be updated in the TXT file
        //  if the job's new information does not meet the following conditions,
        //  the job information should not be updated in the TXT file and the function should return false.


        return true;

    }

// condition 1
//    public static boolean C1jobID(String jobID) {
//        if (jobID.length() != 9 &&
//                !jobID.matches("[1-5]{5}[A-Z]{3}_")) {
//            return false;
//        }
//            return true;
//
//    }
    public static boolean C2Dates(String date){
        if ( isValidDateFormat(date)){
            if (C2_LeapingDates(date)){
                return true;
            }
            return false;
        }
        return false;
    }
    public static boolean C2_LeapingDates(String date){
//      YYYY-MM-DD  have 10 character long
        DateTimeFormatter dateFormatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] Date = date.split("-", 3);     //String[] Year = new String[]{date.split("-", 3)[0]};
//        for (String a : Date)
//            System.out.println(a);

        int year = Integer.parseInt(Date[0]);
        int month = Integer.parseInt(Date[1]);
        int day= Integer.parseInt(Date[2]);

        //2. checking leap year by February test
//        System.out.println("Feb ?");
//        System.out.println(leapYear(year, month, day));
//        System.out.println("30 ?");
//        System.out.println(month_30(month,day));
//        System.out.println("31?");
//        System.out.println(month_31(month,day));
//        System.out.println("========");

        if (leapYear(year, month, day)  || month_30(month,day) || month_31(month,day)){
            return true;
        }
        return false;
    }
    public static boolean leapYear(int year, int month, int day ){
        if (month == 2){
            // the leap year
            if (!( year % 4 == 0 && year % 100 !=0 || year % 400 ==0)){
                if (0<=day && day<=28){     // System.out.println("not a leap year ");
                    return true;
                }
            }else {
                if (0<=day && day<=29){     // System.out.println("Leap year ");
                    return true;
                }
            }
        }return false;

    }
    public static boolean month_31(int month,int day){
        if (month ==1
                || month ==3
                || month ==5
                || month ==7
                || month ==8
                || month ==10
                || month ==12) {
            if ( 0<=day && day<=31){
//                System.out.println("31 days month true ");
                return true;
            }else{
//                System.out.println("date input error");
                return false;}
        }
        // not 31 days month or error inputs
        return false;
    }
    public static boolean month_30(int month,int day){
        if (month ==4
                || month ==6
                || month ==9
                || month ==11
        ) {
            if ( 0<=day && day<=30){
//                System.out.println("30 days month true ");
                return true;
            }else{
//                System.out.println("date input error");
                return false;}
        }
        // not 30 days month or error inputs
        return false;
    }
    public static boolean isValidDateFormat(String date) {
        if (date.length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-'){
            System.out.println("formatting");
            return false;
        }
        if (!date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
            return false;}

//        String dateFormatPattern = "yyyy-MM-dd";
//        try {
//            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormatPattern);
//            LocalDate.parse(date, dateFormatter);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        return true;
    }


// condition 3 City, State, Country. Example: Melbourne, Victoria, Australia.


//    public static void main(String[] args) {
//        String inpt = "12345MMM$";
//        System.out.println(C1jobID(inpt));
//    }

    public static void main(String[] args) {
////      TODO Auto-generated method stub
        String[] array = {"AA AA", "AA"};
//    Job job = new Job("12345mmm_", "A", "B",
//            "C", "D", "E", "F",
//            array, 12, "G");

        String date ="1691-03-04";
        System.out.println(C2_LeapingDates("2022-05-30"));
        System.out.println(C2_LeapingDates("2020-02-99"));
//        System.out.println(isValidDateFormat(date));
//        if (isValidDateFormat(date)){
//            System.out.println(C2JobPostedDate(date));
//        }

        System.out.println(C2Dates(date));


//        System.out.println(!(isValidDateFormat(date)&& (C2JobPostedDate(date))));
//        System.out.println(C2JobPostedDate(date));

    }




}