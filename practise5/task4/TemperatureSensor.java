package practise5.task4;

import java.io.*;
import java.util.Random;

public class TemperatureSensor {
    private static final String FILE_NAME = "sensor.bin";
    private static final int RECORD_COUNT = 60;
    private static final int PATCH_INDEX  = 29; // 30th record (0-based)
    private static final double SPIKE     = 999.9;

    public static void main(String[] args) throws IOException {

        // --- Step 1: Write 60 random temperatures to sensor.bin ---
        Random rand = new Random();
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(FILE_NAME))) {
            for (int i = 0; i < RECORD_COUNT; i++) {
                double temp = 15.0 + (35.0 - 15.0) * rand.nextDouble(); // 15.0–35.0
                dos.writeDouble(temp);
            }
        }
        System.out.println("Written " + RECORD_COUNT + " temperatures to " + FILE_NAME);

        // --- Step 2: Patch index 29 with 999.9 using RandomAccessFile ---
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "rw")) {
            long offset = (long) PATCH_INDEX * 8; // each double = 8 bytes
            raf.seek(offset);
            raf.writeDouble(SPIKE);
        }
        System.out.println("Patched record " + (PATCH_INDEX + 1) +
                           " (index " + PATCH_INDEX + ") with " + SPIKE);

        // --- Step 3: Read back and calculate Average and Max ---
        double sum = 0;
        double max = Double.MIN_VALUE;

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(FILE_NAME))) {
            for (int i = 0; i < RECORD_COUNT; i++) {
                double temp = dis.readDouble();
                sum += temp;
                if (temp > max) max = temp;
            }
        }

        double average = sum / RECORD_COUNT;
        System.out.printf("Average temperature: %.2f °C%n", average);
        System.out.printf("Max temperature:     %.2f °C  (spike confirmed: %b)%n",
                          max, max == SPIKE);
    }
}