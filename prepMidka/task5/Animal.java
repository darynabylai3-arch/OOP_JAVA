package prepMidka.task5;

public class Animal {
    protected String name;
    protected int age;

    protected Animal(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Bark");
    }
}
