package lab2.task4;
public class Resistor extends Circuit {
    private double resistance;
    private double potentialDifference;

    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0.0;
    }

    @Override
    public double getResistance() {
        return resistance;
    }

    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }

    @Override
    public String toString() {
        return String.format("Resistor(R=%.2f Ω, V=%.2f V, I=%.4f A, P=%.4f W)",
                resistance, potentialDifference, getCurrent(), getPower());
    }
}
