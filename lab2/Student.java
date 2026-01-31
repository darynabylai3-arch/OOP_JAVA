package lab2;
import java.util.Scanner;

public class Student{
    private String name ; 
    private int id ; 
    private int year ; 

    public Student(String name , int id){
        this.name = name;
        this.id = id; 
        this.year = 1 ;         
    }
    public String get_name(){
        return name;
    }
    public int get_id(){
        return id;
    }
    
    public int getYear() {
        return year;
    }

    public void incrementYear() {
        year++;
    }
}