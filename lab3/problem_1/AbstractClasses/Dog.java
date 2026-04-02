package lab3.problem_1.AbstractClasses;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Gav";
    }
}