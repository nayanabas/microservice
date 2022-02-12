package com.javabrains.movieinfoservice.Model;

public class Movie {
    private String movieId;
    private String name;
    private String desc;

    public Movie() {
    }



    public Movie(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
