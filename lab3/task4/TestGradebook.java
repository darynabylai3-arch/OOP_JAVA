package task4;

import lab2.Student;

public class TestGradebook {
    public static void main(String[] args) {
        Course course = new Course("Mathematics", "Advanced math course", 3, "None");

        Gradebook gradebook = new Gradebook(course);

        Student s1 = new Student("Pepa", 0);
        Student s2 = new Student("Scheine", 1);
        Student s3 = new Student("Watafa", 2);

        gradebook.addStudent(s1, 85);
        gradebook.addStudent(s2, 92);
        gradebook.addStudent(s3, 76);



        gradebook.displayGradeReport();
    }
}
