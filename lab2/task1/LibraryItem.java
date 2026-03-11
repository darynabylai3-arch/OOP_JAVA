package lab2.task1;
public abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }

    public abstract String getItemType();

    @Override
    public String toString() {
        return getItemType() + " | Title: " + title + " | Author: " + author + " | Year: " + publicationYear;
    }
}

class Book extends LibraryItem {
    private int numberOfPages;
    private String isbn;
    private String genre;

    public Book(String title, String author, int publicationYear, int numberOfPages, String isbn, String genre) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.genre = genre;
    }

    public int getNumberOfPages() { return numberOfPages; }
    public String getIsbn() { return isbn; }
    public String getGenre() { return genre; }

    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setGenre(String genre) { this.genre = genre; }

    public boolean isLongBook() {
        return numberOfPages > 300;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String toString() {
        return super.toString() +
               " | Pages: " + numberOfPages +
               " | ISBN: " + isbn +
               " | Genre: " + genre +
               " | Long Book: " + isLongBook();
    }
}

class TestLibrary {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, "978-0743273565", "Fiction");
        Book book2 = new Book("Clean Code", "Robert C. Martin", 2008, 431, "978-0132350884", "Technology");
        Book book3 = new Book("Dune", "Frank Herbert", 1965, 688, "978-0441013593", "Science Fiction");

        LibraryItem[] items = { book1, book2, book3 };

        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }
}
