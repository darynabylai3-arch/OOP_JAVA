import lab2.Student;
import java.util.Scanner;

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course course = new Course(
                "CS101",
                "Object-Oriented Programming",
                5,
                "None"
        );

        GradeBook gb = new GradeBook(course);
        gb.displayMessage();

        System.out.println("Enter grades for students:");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Student " + i + " ID: ");
            int id = sc.nextInt();

            System.out.print("Grade: ");
            int grade = sc.nextInt();

            gb.addStudent(new Student("Student" + i, id), grade);
        }

        gb.displayGradeReport();
    }
}
