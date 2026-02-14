package pr3.animal.model;

public class Dog extends Animal{
    protected String breed;
    
    public Dog(String name, int age,String breed){
        super(name, age);
        this.breed = breed;
    }
    @Override
    public void makeSound(){
        System.out.println(name + " barks: Woof! Woof!");
    }
    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Breed: " + breed);
    }
}   
