package lab4.task2;

interface CanHavePizza {
    void eatPizza();
}
interface CanHaveRetake{
    void retakeExam();
}
interface Movable{
    void canDance();
    void canMove();
}

class Cat implements CanHavePizza{
    public void eatPizza(){
        System.out.println("Meow");
    }
}
class Person{
    //cant eat pizza ;(
}

class Student extends Person implements CanHavePizza,CanHaveRetake,Movable{
    public void eatPizza(){
        System.out.println("Stundent eating pizza");
    }
    public void retakeExam(){
        System.out.println("Stundent takes retake ;(");
    }
    public void canDance(){
        System.out.println("Stundent eating dancing");
    }
    public void canMove(){
        System.out.println("Stundent eating moving");
    }
}

class Restaurant{
    boolean servePizza(CanHavePizza eater){
        eater.eatPizza();
        if (eater instanceof Person){
            System.out.println("Paid for pizza 5$");
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Cat cat = new Cat();
        Student student = new Student();

        restaurant.servePizza(cat);
        restaurant.servePizza(student);
    }
}