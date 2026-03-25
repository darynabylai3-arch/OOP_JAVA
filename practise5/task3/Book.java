package practise5.task3;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private transient int visitCount = 0; // not saved to file

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void visit() { visitCount++; }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int getVisitCount(){ return visitCount; }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (visits this session: " + visitCount + ")";
    }
}