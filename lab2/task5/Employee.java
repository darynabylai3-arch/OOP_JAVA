package lab2.task5;
public class Employee extends Person {
    private String position;

    public Employee(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public String getPosition() { return position; }

    @Override
    public String getOccupation() { return "Employee, position=" + position; }
}

class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }

    @Override
    public String getOccupation() { return "Student, major=" + major; }
}

class PhDStudent extends Student {
    private String researchTopic;

    public PhDStudent(String name, int age, String major, String researchTopic) {
        super(name, age, major);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() { return researchTopic; }

    @Override
    public String getOccupation() {
        return "PhD Student, major=" + getMajor() + ", research=" + researchTopic;
    }

    @Override
    protected boolean canAcceptPet(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println(getName() + " (PhD student) cannot have a dog — too busy with research!");
            return false;
        }
        return true;
    }
}
