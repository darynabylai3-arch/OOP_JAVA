package lab2.task5;
public class PetTest {
    public static void main(String[] args) {
        Person john  = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");
        Person bob   = new Student("Bob", 22, "Biology");

        Animal murka = new Cat("Murka", 5);
        Animal rex   = new Dog("Rex", 3);
        Animal tweety = new Bird("Tweety", 2);

        john.assignPet(murka);
        bob.assignPet(tweety);

        System.out.println("--- Trying to give Alice a Dog ---");
        alice.assignPet(rex);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);

        System.out.println("\n--- Initial State ---");
        System.out.println(registry);

        System.out.println("--- John goes on vacation, leaves Murka with Alice ---");
        john.leavePetWith(alice);
        System.out.println(registry);

        System.out.println("--- Bob tries to leave Tweety with Alice (Alice already has a pet) ---");
        bob.leavePetWith(alice);
        System.out.println();

        System.out.println("--- John returns from vacation and retrieves Murka ---");
        john.retrievePetFrom(alice);
        System.out.println(registry);

        System.out.println("--- Edge case: Alice (no pet) tries to leave a pet ---");
        alice.leavePetWith(bob);
    }
}
