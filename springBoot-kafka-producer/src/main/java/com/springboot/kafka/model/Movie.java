package com.springboot.kafka.model;

public class Movie{
    private String name;
    private String director;

    public String getMovieName() {
        return name;
    }

    public void setMovieName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String name, String director) {
        this.name = name;
        this.director = director;
    }

    public Movie() {
    }

}