package lab3.problem_6;

import lab3.problem_1.AbstractClasses.Animal;
import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal implements Trainable, Comparable<Dog> {
    private List<String> learnedCommands = new ArrayList<>();

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Gav";
    }

    @Override
    public boolean train(String command) {
        if (!learnedCommands.contains(command)) {
            learnedCommands.add(command);
            return true;
        }
        return false;
    }

    @Override
    public String[] getLearnedCommands() {
        return learnedCommands.toArray(new String[0]);
    }

    @Override
    public int compareTo(Dog other) {
        return Integer.compare(this.learnedCommands.size(), other.learnedCommands.size());
    }

    @Override
    public String toString() {
        return describe() + " | Commands learned: " + learnedCommands.size();
    }
}