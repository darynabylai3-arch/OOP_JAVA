package lab2.task5;
import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people;

    public PersonRegistry() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        if (!people.contains(p)) people.add(p);
    }

    public void removePerson(Person p) {
        people.remove(p);
    }

    public List<Person> getPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) if (p.hasPet()) result.add(p);
        return result;
    }

    public List<Person> getPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) if (!p.hasPet()) result.add(p);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== PersonRegistry ===\n");
        for (Person p : people) sb.append("  ").append(p).append("\n");
        return sb.toString();
    }
}
