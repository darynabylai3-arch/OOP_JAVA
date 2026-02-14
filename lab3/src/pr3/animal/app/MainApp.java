package pr3.animal.app;
import pr3.animal.model.Animal;
import pr3.animal.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Animal cat = new Animal("Aktos", 3);
        Dog dog1 = new Dog("Mukhtar", 5, "Ovcharka");
        Dog dog2 = new Dog("Max", 2, "Laika");

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog1);
        animals.add(dog2);

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);

            a.getInfo();
            a.makeSound();
            a.eat();
            a.eat("meat");
    System.out.println();
    }
}
}