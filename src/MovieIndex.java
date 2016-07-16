/**
 * Created by Ignacio on 7/16/16.
 */
public class MovieIndex implements Comparable<MovieIndex> {
    private Movie movie;
    private long position;


    public MovieIndex(Movie movie, long position) {
        this.movie = movie;
        this.position = position;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public int compareTo(MovieIndex o) {
        return movie.getTitle().compareTo(o.getMovie().getTitle());
    }
}
