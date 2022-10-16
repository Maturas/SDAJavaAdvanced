package org.SDA.GameDatabase;

public class VideoGame {
    private final String title;
    private final String genre;
    private final Integer releaseYear;
    private final Double soldUnitsInMillions;

    public VideoGame(String title, String genre, Integer releaseYear, Double soldUnitsInMillions) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.soldUnitsInMillions = soldUnitsInMillions;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Double getSoldUnitsInMillions() {
        return soldUnitsInMillions;
    }
}
