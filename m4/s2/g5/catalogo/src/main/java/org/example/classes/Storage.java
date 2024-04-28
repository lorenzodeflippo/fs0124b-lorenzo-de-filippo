package org.example.classes;

import java.util.Random;

public abstract class Storage {
    protected long codISBN;
    protected String title;
    protected int yearPublication;
    protected int numPages;

    public Storage(String title, int numPages) {
        Random rnd = new Random();
        this.codISBN = rnd.nextLong();
        this.title = title;
        this.yearPublication = rnd.nextInt(1950, 2224);
        this.numPages = numPages;
    }

    public Storage(long codISBN, String title, int yearPublication, int numPages) {
        this.codISBN = codISBN;
        this.title = title;
        this.yearPublication = yearPublication;
        this.numPages = numPages;
    }

    public long getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(long codISBN) {
        this.codISBN = codISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "codISBN=" + codISBN +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                ", numPages=" + numPages +
                '}';
    }
}
