package midTermPrep.task5;

public class Dog extends Animal {
    public String breed;
    
    public Dog(String name,int age,String breed){
        super(name,age);
        this.breed = breed;
    }

    @Override
    public void makeSound(){
        System.out.println("The dogs breed is : " + breed);
    }
}
