package lab1.task4;
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    double gpa;

    Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    public String toString() {
        return name + " (" + gpa + ")";
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 3.2));
        students.add(new Student("Charlie", 3.9));
        students.add(new Student("Diana", 3.5));

        System.out.println("Original list:");
        System.out.println(students);

        Collections.sort(students);
        System.out.println("\nSorted by GPA:");
        System.out.println(students);

        Collections.sort(students, new NameComparator());
        System.out.println("\nSorted by Name:");
        System.out.println(students);
    }
}