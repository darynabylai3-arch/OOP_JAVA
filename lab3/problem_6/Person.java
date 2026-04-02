package lab3.problem_6;

public class Person implements Sociable, Cloneable, Comparable<Person> {
    private String name;
    private int age;
    private Dog pet;

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public void adoptPet(Dog dog) {
        this.pet = dog;
    }

    @Override
    public String greet() {
        return "Hi, my name is " + name + " and I am " + age + " years old.";
    }

    @Override
    public String interactWith(String otherName) {
        return name + " waves hello to " + otherName + "!";
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        String petInfo = (pet != null) ? " | Pet: " + pet : " | No pet";
        return "Person{name='" + name + "', age=" + age + "}" + petInfo;
    }
}