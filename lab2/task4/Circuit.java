package lab2.task4;
public abstract class Circuit {
    public abstract double getResistance();
    public abstract double getPotentialDiff();
    public abstract void applyPotentialDiff(double V);

    public double getPower() {
        double V = getPotentialDiff();
        double R = getResistance();
        return (V * V) / R;
    }

    public double getCurrent() {
        return getPotentialDiff() / getResistance();
    }
}
