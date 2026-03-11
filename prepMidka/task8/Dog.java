package prepMidka.task8;

public class Dog extends Animal{
    String breed;

    public Dog(String name,Integer age,String breed){
        super(name, age);
        this.breed = breed;
    }

    @Override 
    public void makeSound(){
        System.out.println("heeeeeeey I AM " + breed);
    }
}
