package pr3.animal.model;
public class Animal {
    protected String name; 
    protected int age; 

    public Animal(String name, int age){
        this.name = name; 
        this.age = age ;
    }
    public void makeSound(){
        System.out.println(name + " making sound");
    }
    public void eat(){
        System.out.println(name + " eating food");
    }
    public void eat(String food) {
        System.out.println(name + " is eating " + food + ".");
    }
    public void getInfo(){
        System.out.println("name is "+ name + "age is: "+ age);
    }
}
