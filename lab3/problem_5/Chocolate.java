package lab3.problem_5;

public class Chocolate implements Comparable<Chocolate> {
    private double weight;
    private String name;

    public Chocolate(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() { return weight; }
    public String getName()   { return name; }

    @Override
    public String toString() {
        return "Chocolate{name='" + name + "', weight=" + weight + "g}";
    }

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }
}
