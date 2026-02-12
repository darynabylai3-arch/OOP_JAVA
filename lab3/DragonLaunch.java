import java.util.Vector;

public class DragonLaunch {

    private Vector<Person> people = new Vector<>();

    public void kidnap(Person p) {
        people.add(p);
    }

    public boolean willDragonEatOrNot() {
        int i = 0;

        while (i < people.size() - 1) {
            Person p1 = people.get(i);
            Person p2 = people.get(i + 1);

            if (p1.getGender() == Gender.BOY &&
                p2.getGender() == Gender.GIRL) {

                people.remove(i + 1);
                people.remove(i);

                if (i > 0) i--;
            } else {
                i++;
            }
        }

        return people.size() > 0;
    }

    @Override
    public String toString() {
        return people.toString();
    }
}
