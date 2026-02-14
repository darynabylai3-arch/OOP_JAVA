package task4;

public class Course {
    private String name;
    private String description;
    private int credits;
    private String prereq;

    public Course(String name, String description, int credits, String prereq){
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.prereq = prereq;
    }
    @Override
    public String toString(){
        return name + " (" + credits + " credits)";
    }
}
