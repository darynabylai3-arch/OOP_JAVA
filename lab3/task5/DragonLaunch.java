package task5;

import java.util.Stack;

public class DragonLaunch {

    private Stack<Person> people = new Stack<>();

    public void kidnap(Person p) {
        people.push(p);

        while (people.size() >= 2) {
            Person top = people.pop();
            Person next = people.pop();

            if (!(top.getGender() == Gender.GIRL && next.getGender() == Gender.BOY)) {
                // если не пара BOY-GIRL пихаем обратно
                people.push(next);
                people.push(top);
                break;
            }
        }
    }

    public boolean willDragonEatOrNot() {
        return !people.isEmpty();
    }

    @Override
    public String toString() {
        return people.toString();
    }
}
