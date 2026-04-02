package lab3.problem_6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Dog rex   = new Dog("Rex");
        Dog buddy = new Dog("Buddy");

        rex.train("Sit");
        rex.train("Stay");
        rex.train("Fetch");
        buddy.train("Sit");

        System.out.println(rex);
        System.out.println("Rex's commands: " + Arrays.toString(rex.getLearnedCommands()));
        System.out.println("Buddy's commands: " + Arrays.toString(buddy.getLearnedCommands()));
        System.out.println("More trained: " + (rex.compareTo(buddy) > 0 ? "Rex" : "Buddy"));

        Person alice = new Person("Alice", 30);
        Person bob   = new Person("Bob", 25);
        alice.adoptPet(rex);

        System.out.println("\n" + alice);
        System.out.println(alice.greet());
        System.out.println(alice.interactWith("Bob"));

        Person aliceClone = (Person) alice.clone();
        System.out.println("\nCloned: " + aliceClone);
        System.out.println("Older: " + (alice.compareTo(bob) > 0 ? "Alice" : "Bob"));
    }
}