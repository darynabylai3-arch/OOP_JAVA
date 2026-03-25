package practise5.task2;
import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Read input.txt and count words
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input.txt: " + e.getMessage());
            return;
        }

        // Sort by frequency descending
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Write report.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            for (Map.Entry<String, Integer> entry : entries) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Report written to report.txt");
        } catch (IOException e) {
            System.out.println("Error writing report.txt: " + e.getMessage());
        }
    }
}