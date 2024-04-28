package org.example.classes;

public class Book extends Storage {

    private String Author;
    private String type;


    public Book(String title, int numPages, String author, String type) {
        super(title, numPages);
        this.Author = author;
        this.type = type;
    }

    public Book(long codISBN, String title, int yearPublication, int numPages, String author, String type) {
        super(codISBN, title, yearPublication, numPages);
        this.Author = author;
        this.type = type;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book:" + "title='" + getTitle() + ", yearPublication=" + getYearPublication() + ", numPages=" + getNumPages() + ", author=" + Author + ", type=" + type;
    }
}
