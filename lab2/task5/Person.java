package lab2.task5;
import java.util.Objects;

public abstract class Person {
    private String name;
    private int age;
    private Animal pet;
    private Animal tempStoredPet;
    private Person tempCaretaker;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public Animal getPet() { return pet; }

    public abstract String getOccupation();

    protected boolean canAcceptPet(Animal animal) {
        return true;
    }

    public void assignPet(Animal animal) {
        if (!canAcceptPet(animal)) {
            System.out.println(name + " cannot have a " + animal.getClass().getSimpleName() + ".");
            return;
        }
        this.pet = animal;
    }

    public void removePet() {
        this.pet = null;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " has no pet to leave.");
            return;
        }
        if (!caretaker.canAcceptPet(pet)) {
            System.out.println(caretaker.getName() + " cannot take care of a "
                    + pet.getClass().getSimpleName() + ".");
            return;
        }
        if (caretaker.hasPet()) {
            System.out.println(caretaker.getName() + " already has a pet and cannot take another.");
            return;
        }
        this.tempStoredPet = this.pet;
        this.tempCaretaker = caretaker;
        caretaker.assignPet(this.pet);
        this.pet = null;
        System.out.println(name + " left " + tempStoredPet.getName() + " with " + caretaker.getName() + ".");
    }

    public void retrievePetFrom(Person caretaker) {
        if (tempStoredPet == null) {
            System.out.println(name + " has no pet stored with anyone.");
            return;
        }
        if (!caretaker.hasPet() || caretaker.getPet() != tempStoredPet) {
            System.out.println(caretaker.getName() + " does not have " + name + "'s pet.");
            return;
        }
        caretaker.removePet();
        this.pet = tempStoredPet;
        this.tempStoredPet = null;
        this.tempCaretaker = null;
        System.out.println(name + " retrieved " + pet.getName() + " from " + caretaker.getName() + ".");
    }

    @Override
    public String toString() {
        String petInfo = hasPet() ? pet.toString() : "no pet";
        String caretakerInfo = (tempStoredPet != null)
                ? " [" + tempStoredPet.getName() + " is with " + tempCaretaker.getName() + "]"
                : "";
        return name + " (age=" + age + ", " + getOccupation() + ") | Pet: " + petInfo + caretakerInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
