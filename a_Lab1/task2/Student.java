package quiz_1.task2;
public class Student {
    public enum GradeLevel {
        FRESHMAN(1),
        SOPHOMORE(2),
        JUNIOR(3),
        SENIOR(4);
        
        private final int year;
        
        GradeLevel(int year) {
            this.year = year;
        }
        
        public int getYear() {
            return year;
        }
    }
    
    public static final String SCHOOL_NAME = "City High School";
    public static final int MAX_COURSES = 6;
    
    private static int totalStudentsEnrolled = 0;
    private static double totalGpaSum = 0.0;
    
    private final String studentId;
    private final GradeLevel gradeLevel;
    private final int enrollmentYear;
    
    private String name;
    private double gpa;
    private int creditsCompleted;
    private int numberOfCourses;
    
    {
        this.enrollmentYear = 2024;
        this.creditsCompleted = 0;
        this.numberOfCourses = 0;
        Student.totalStudentsEnrolled++;
        System.out.println("New student record created. Total enrolled: " + totalStudentsEnrolled);
    }
    
    public Student(String name, GradeLevel gradeLevel, double gpa) {
        this(name, gradeLevel);
        this.gpa = gpa;
        totalGpaSum += gpa;
    }
    
    public Student(String name, GradeLevel gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.studentId = "S" + (1000 + totalStudentsEnrolled);
        this.gpa = 0.0;
    }
    
    public void addGrade(String letterGrade) {
        this.addGrade(letterGrade, 3.0);
    }
    
    public void addGrade(String letterGrade, double credits) {
        double gradePoints = 0.0;
        
        if (letterGrade.equals("A")) gradePoints = 4.0;
        else if (letterGrade.equals("B")) gradePoints = 3.0;
        else if (letterGrade.equals("C")) gradePoints = 2.0;
        else if (letterGrade.equals("D")) gradePoints = 1.0;
        else gradePoints = 0.0;
        
        double currentTotal = this.gpa * this.creditsCompleted;
        this.creditsCompleted += credits;
        currentTotal += gradePoints * credits;
        this.gpa = currentTotal / this.creditsCompleted;
        this.numberOfCourses++;
    }
    
    public void promote() {
        if (this.gradeLevel == GradeLevel.FRESHMAN) {
            GradeLevel newLevel = GradeLevel.SOPHOMORE;
        } else if (this.gradeLevel == GradeLevel.SOPHOMORE) {
            GradeLevel newLevel = GradeLevel.JUNIOR;
        } else if (this.gradeLevel == GradeLevel.JUNIOR) {
            GradeLevel newLevel = GradeLevel.SENIOR;
        }
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }
    
    public int getEnrollmentYear() {
        return enrollmentYear;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public int getCreditsCompleted() {
        return creditsCompleted;
    }
    
    public int getNumberOfCourses() {
        return numberOfCourses;
    }
    
    public static int getTotalStudentsEnrolled() {
        return totalStudentsEnrolled;
    }
    
    public static double getAverageGpa() {
        if (totalStudentsEnrolled == 0) return 0.0;
        return totalGpaSum / totalStudentsEnrolled;
    }
}