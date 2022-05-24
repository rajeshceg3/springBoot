package com.springboot.kafka.model;

public class Movie{
    private String name;
    private String director;

    public String getMovieName() {
        return bookName;
    }

    public void setMovieName(String bookName) {
        this.bookName = bookName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String bookName, String director) {
        this.bookName = bookName;
        this.director = director;
    }

    public Movie() {
    }

}