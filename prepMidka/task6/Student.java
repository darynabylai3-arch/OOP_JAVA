package prepMidka.task6;

public class Student {
    String ID; 
    String name;
    Integer year;

    public Student(String ID,String name){
        this.ID = ID;
        this.name = name;
        this.year = 1;
    }

    public String get_name(){
        return name;
    }
    public void inrementYear(){
        year++;
    }
}
