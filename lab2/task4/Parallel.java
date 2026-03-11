package lab2.task4;
public class Parallel extends Circuit {
    private Circuit first;
    private Circuit second;
    private double potentialDifference;

    public Parallel(Circuit first, Circuit second) {
        this.first = first;
        this.second = second;
        this.potentialDifference = 0.0;
    }

    @Override
    public double getResistance() {
        return 1.0 / (1.0 / first.getResistance() + 1.0 / second.getResistance());
    }

    @Override
    public double getPotentialDiff() {
        return potentialDifference;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
        first.applyPotentialDiff(V);
        second.applyPotentialDiff(V);
    }

    @Override
    public String toString() {
        return String.format("Parallel(R=%.2f Ω, V=%.2f V, I=%.4f A, P=%.4f W)\n  [%s]\n  [%s]",
                getResistance(), potentialDifference, getCurrent(), getPower(), first, second);
    }
}
