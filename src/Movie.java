/**
 * Created by matias on 6/22/16.
 */
public class Movie implements Comparable<Movie> {
    private String title; // 50 Bytes + 2
    private int year; // 4 Bytes
    private String genre; // 20 Bytes + 2
    private boolean isAvailable; // 1 Byte
    //Total 79 Bytes


    public Movie() {

    }

    public Movie(String title, int year, String genre, boolean isAvailable) {
        this.title = Utilities.adapt(title, 50);
        this.year = year;
        this.genre = Utilities.adapt(genre, 20);
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString() {
        return "Movie name: " + title + "\nYear released: " + year + "\nGenre: " + genre + "\n is available: " + isAvailable;
    }

    @Override
    public int compareTo(Movie o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
