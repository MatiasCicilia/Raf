/**
 * Created by matias on 6/22/16.
 */
public class Movie {
    private String title;
    private int year;
    private boolean isChildFriendly;
    private String genre;
    private boolean isAvailable;

    public Movie(String title, int year, String genre, boolean isChildFriendly) {
        this.title = title;
        this.year = year;
        this.isChildFriendly = isChildFriendly;
        this.genre = genre;
        isAvailable = true;
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

    public boolean isChildFriendly() {
        return isChildFriendly;
    }

    public void setChildFriendly(boolean childFriendly) {
        isChildFriendly = childFriendly;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
