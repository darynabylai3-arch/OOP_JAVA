package lab2.task4;
public class Series extends Circuit {
    private Circuit first;
    private Circuit second;
    private double potentialDifference;

    public Series(Circuit first, Circuit second) {
        this.first = first;
        this.second = second;
        this.potentialDifference = 0.0;
    }

    @Override
    public double getResistance() {
        return first.getResistance() + second.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
        double current = V / getResistance();
        first.applyPotentialDiff(current * first.getResistance());
        second.applyPotentialDiff(current * second.getResistance());
    }

    @Override
    public String toString() {
        return String.format("Series(R=%.2f Ω, V=%.2f V, I=%.4f A, P=%.4f W)\n  [%s]\n  [%s]",
                getResistance(), potentialDifference, getCurrent(), getPower(), first, second);
    }
}
