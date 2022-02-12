package com.javabrains.ratingsservice.model;


public class Rating {

    private String movieId;
    private int rating;

    public Rating() {
    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

//    public String getUserId() {
//        return userId;
//    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
