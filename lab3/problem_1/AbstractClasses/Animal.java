package lab3.problem_1.AbstractClasses;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String describe() {
        return "I am " + name + " and I say " + makeSound();
    }

    public abstract String makeSound();
}