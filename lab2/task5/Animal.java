package lab2.task5;
public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public abstract String getSound();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "('" + name + "', age=" + age + ", sound='" + getSound() + "')";
    }
}
