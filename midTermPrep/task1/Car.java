package midTermPrep.task1;

public class Car {
    private String brand; 
    private String model; 
    private int year; 

    public Car(String brand, String model,int year){
        this.brand = brand;
        this.model = model; 
        this.year = year;
    }
    
    public void startEngine(){
        System.out.println("Engine Started");
    }
    public void Display(){
        System.out.println(brand);
        System.out.println(model);
        System.out.println(year);
    }
}