package org.agoncal.quarkus.starting;

public class Book {

    public int id;
    public String title;
    public String author;
    public int yearofPublication;
    public String genre;
    
    public Book(int id, String title, String author, int yearofPublication, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearofPublication = yearofPublication;
        this.genre = genre;
    }
    


}
