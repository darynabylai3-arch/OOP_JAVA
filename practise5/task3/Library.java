package practise5.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static final String FILE_NAME = "library.dat";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        // Load existing library from file
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                books = (ArrayList<Book>) ois.readObject();
                System.out.println("Library loaded. (" + books.size() + " books)");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Could not load library: " + e.getMessage());
            }
        } else {
            System.out.println("No existing library found. Starting fresh.");
        }

        // Menu loop
        Scanner scan = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("Q")) {
            System.out.println("\n(A)dd a book  |  (L)ist books  |  (Q)uit");
            System.out.print("Choice: ");
            choice = scan.nextLine().trim();

            if (choice.equalsIgnoreCase("A")) {
                System.out.print("Title: ");
                String title = scan.nextLine();
                System.out.print("Author: ");
                String author = scan.nextLine();
                books.add(new Book(title, author));
                System.out.println("Book added!");

            } else if (choice.equalsIgnoreCase("L")) {
                if (books.isEmpty()) {
                    System.out.println("No books in library.");
                } else {
                    for (int i = 0; i < books.size(); i++) {
                        Book b = books.get(i);
                        b.visit();
                        System.out.println((i + 1) + ". " + b);
                    }
                }
            }
        }

        // Save library to file on quit
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
            System.out.println("Library saved. Goodbye!");
        } catch (IOException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }

        scan.close();
    }
}