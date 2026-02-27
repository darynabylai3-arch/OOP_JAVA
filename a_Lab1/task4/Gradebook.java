package quiz_1.task4;
import lab2.Student;
import java.util.ArrayList;
import java.util.Collections;

public class Gradebook {
    private Course course;
    private ArrayList<Student> students;
    private ArrayList<Integer> grades;

    public Gradebook(Course course){
        this.course = course;
        students = new ArrayList<>();
        grades = new ArrayList<>();
    }
    public void addStudent(Student s,int grade){
        students.add(s);
        grades.add(grade);
    }
    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course);
    }
    public double determineClassAverage(){
        double sum = 0 ;

        for(int i =0 ;i < grades.size() ; i++){
            sum += grades.get(i) ; 
        }
        return sum / grades.size();
    }

    public void minValue(){
        if (grades.isEmpty()) {
        System.out.println("There is no grades");
        return;
    }
        int minIndex_forName = 0;
        int minGrade = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < minGrade) {
                minGrade = grades.get(i);
                minIndex_forName = i;
            }
        }
        System.out.println("min value is: "+minGrade+" from student: "+students.get(minIndex_forName));
   }
   public void maxValue() {
    if (grades.isEmpty()) {
        System.out.println("There is no grades");
        return;
    }
    
    int maxIndex = 0;
    int maxGrade = grades.get(0);
    
    for (int i = 1; i < grades.size(); i++) {
        if (grades.get(i) > maxGrade) {
            maxGrade = grades.get(i);
            maxIndex = i;
        }
    }
    System.out.println("max value is: " + maxGrade + 
                      " from student: " + students.get(maxIndex));
    }
    public void outputBarChart() {
    int[] freq = new int[11];
    
    for (int i = 0; i < grades.size(); i++) {
        int grade = grades.get(i);
        freq[grade / 10]++;
    }
    
    System.out.println("Grade distribution:");

    for (int i = 0; i < freq.length; i++) {
        if (i == 10) {
            System.out.print("100: ");
        } else {
            System.out.print(i * 10 + "-" + (i * 10 + 9) + ": ");
        }

        for (int j = 0; j < freq[i]; j++) {
            System.out.print("*");
        }
        System.out.println();
        }
    }
    public void displayGradeReport() {
    System.out.println("\n" + "=".repeat(50));
    System.out.println("          GRADE REPORT FOR " + course);
    System.out.println("=".repeat(50));
    
    // Проверка на наличие данных
    if (grades.isEmpty()) {
        System.out.println("No grades available to display report.");
        System.out.println("=".repeat(50));
        return;
    }
    
    // 1. Средняя оценка
    System.out.printf("\n CLASS AVERAGE: %.2f\n", determineClassAverage());
    
    // 2. Лучшая и худшая оценки
    System.out.println("\n BEST PERFORMANCE:");
    maxValue();
    
    System.out.println("\n WORST PERFORMANCE:");
    minValue();
    
    // 3. Гистограмма
    System.out.println("\n GRADE DISTRIBUTION:");
    outputBarChart();
    
    // Дополнительная статистика
    System.out.println("\n SUMMARY:");
    System.out.println("   Total students: " + grades.size());   
}
}
