import lab2.Student;
import java.util.ArrayList;

public class GradeBook {
    private Course course;
    private ArrayList<Student> students;
    private ArrayList<Integer> grades;

    public GradeBook(Course course) {
        this.course = course;
        students = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public void addStudent(Student s, int grade) {
        students.add(s);
        grades.add(grade);
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course);
    }

    public double determineClassAverage() {
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    public void displayGradeReport() {
        int max = grades.get(0);
        int min = grades.get(0);
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) > max) {
                max = grades.get(i);
                maxIndex = i;
            }
            if (grades.get(i) < min) {
                min = grades.get(i);
                minIndex = i;
            }
        }

        System.out.println("Class average is " + determineClassAverage());
        System.out.println("Lowest grade is " + min +
                " (Student ID: " + students.get(minIndex).get_id() + ")");
        System.out.println("Highest grade is " + max +
                " (Student ID: " + students.get(maxIndex).get_id() + ")");

        outputBarChart();
    }

    public void outputBarChart() {
        int[] freq = new int[11];

        for (int g : grades) {
            freq[g / 10]++;
        }

        System.out.println("Grade distribution:");
        for (int i = 0; i < freq.length; i++) {
            if (i == 10)
                System.out.print("100: ");
            else
                System.out.print(i * 10 + "-" + (i * 10 + 9) + ": ");

            for (int j = 0; j < freq[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "GradeBook for " + course;
    }
}
