package org.example.classes;

public class Magazine extends Storage {
    private Enum periodicity;

    public Magazine(String title, int numPages, Enum periodicity) {
        super(title, numPages);
        this.periodicity = periodicity;
    }

    public Magazine(long codISBN, String title, int yearPublication, int numPages, Enum periodicity) {
        super(codISBN, title, yearPublication, numPages);
        this.periodicity = periodicity;
    }


    public Enum getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Enum periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine:" + "title='" + getTitle() + ", yearPublication=" + getYearPublication() + ", numPages=" + getNumPages() + ", periodicity=" + periodicity;
    }
}
