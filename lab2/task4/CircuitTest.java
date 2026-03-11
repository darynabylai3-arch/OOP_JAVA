package lab2.task4;
public class CircuitTest {
    public static void main(String[] args) {
        Circuit r1 = new Resistor(7.0);
        Circuit r2 = new Resistor(10.0);
        Circuit r3 = new Resistor(6.0);
        Circuit r4 = new Resistor(4.0);

        Circuit c1 = new Parallel(r1, r2);   // R1 || R2
        Circuit c2 = new Series(r3, r4);     // R3 + R4
        Circuit circuit = new Parallel(c1, c2); // (R1||R2) || (R3+R4)

        double R = circuit.getResistance();
        System.out.printf("Equivalent Resistance: %.4f Ω%n%n", R);

        circuit.applyPotentialDiff(24.0);

        System.out.printf("Applied Voltage:  %.2f V%n", circuit.getPotentialDiff());
        System.out.printf("Total Current:    %.4f A%n", circuit.getCurrent());
        System.out.printf("Total Power:      %.4f W%n%n", circuit.getPower());

        System.out.println("=== Circuit Breakdown ===");
        System.out.println(circuit);
    }
}
