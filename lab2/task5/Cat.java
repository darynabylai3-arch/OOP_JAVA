package lab2.task5;
public class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Meow"; }
}

class Dog extends Animal {
    public Dog(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Woof"; }
}

class Bird extends Animal {
    public Bird(String name, int age) { super(name, age); }
    @Override public String getSound() { return "Tweet"; }
}

class Fish extends Animal {
    public Fish(String name, int age) { super(name, age); }
    @Override public String getSound() { return "..."; }
}
