package lab2.task1;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Animal {
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Animal [Name: " + name + ", Species: " + species + ", Age: " + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
               Objects.equals(name, animal.name) &&
               Objects.equals(species, animal.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species, age);
    }
}

class Dog extends Animal {
    private String breed;
    private String microchipId;

    public Dog(String name, int age, String breed, String microchipId) {
        super(name, "Canis lupus familiaris", age);
        this.breed = breed;
        this.microchipId = microchipId;
    }

    public String getBreed() { return breed; }
    public String getMicrochipId() { return microchipId; }

    public void setBreed(String breed) { this.breed = breed; }
    public void setMicrochipId(String microchipId) { this.microchipId = microchipId; }

    @Override
    public String toString() {
        return "Dog [Name: " + getName() + ", Age: " + getAge() +
               ", Breed: " + breed + ", Microchip: " + microchipId + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(microchipId, dog.microchipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(microchipId);
    }
}

class TestAnimal {
    public static void main(String[] args) {
        System.out.println("=== Animal HashSet Test ===");
        Set<Animal> animalSet = new HashSet<>();
        Animal a1 = new Animal("Leo", "Panthera leo", 5);
        Animal a2 = new Animal("Nemo", "Amphiprioninae", 2);
        Animal a3 = new Animal("Leo", "Panthera leo", 5);

        animalSet.add(a1);
        animalSet.add(a2);
        animalSet.add(a3);

        System.out.println("Added 3 animals (a1 and a3 are duplicates)");
        System.out.println("HashSet size (expected 2): " + animalSet.size());
        for (Animal a : animalSet) {
            System.out.println(a);
        }

        System.out.println("\n=== Dog HashSet Test ===");
        Set<Dog> dogSet = new HashSet<>();
        Dog d1 = new Dog("Rex", 3, "German Shepherd", "MC-001");
        Dog d2 = new Dog("Bella", 4, "Labrador", "MC-002");
        Dog d3 = new Dog("Rex", 3, "German Shepherd", "MC-001");
        Dog d4 = new Dog("Max", 5, "Bulldog", "MC-003");

        dogSet.add(d1);
        dogSet.add(d2);
        dogSet.add(d3);
        dogSet.add(d4);

        System.out.println("Added 4 dogs (d1 and d3 share same microchip = duplicate)");
        System.out.println("HashSet size (expected 3): " + dogSet.size());
        for (Dog d : dogSet) {
            System.out.println(d);
        }

        System.out.println("\n=== Equality Checks ===");
        System.out.println("a1.equals(a3): " + a1.equals(a3));
        System.out.println("a1.equals(a2): " + a1.equals(a2));
        System.out.println("d1.equals(d3): " + d1.equals(d3));
        System.out.println("d1.equals(d2): " + d1.equals(d2));
    }
}
