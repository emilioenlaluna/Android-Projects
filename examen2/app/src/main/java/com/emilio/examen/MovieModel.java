package com.emilio.examen;

public class MovieModel {

    int movieImage;
    String movieName;
    String releaseYear;
    String platform;

    public MovieModel(int movieImage, String movieName, String releaseYear, String platform) {
        this.movieImage = movieImage;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.platform = platform;
    }

    public int getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(int movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
