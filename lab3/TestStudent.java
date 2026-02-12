public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", Student.GradeLevel.FRESHMAN, 3.5);
        Student s2 = new Student("Bob", Student.GradeLevel.SOPHOMORE);

        s2.addGrade("A", 3);
        s2.addGrade("B", 4);

        System.out.println(s1.getName() + " GPA: " + s1.getGpa());
        System.out.println(s2.getName() + " GPA: " + s2.getGpa());
        System.out.println("Total students: " + Student.getTotalStudentsEnrolled());
    }
}
