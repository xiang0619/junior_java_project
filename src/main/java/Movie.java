import java.util.Date;

public class Movie {
    private String movieName;
    private String movieID;
    private String movieType;
    private Date mReleaseDate;
    private int mDuration;
    private double price;

    public Movie(String movieName, String movieID, String movieType, Date mReleaseDate, int mDuration, double price) {
        this.movieName = movieName;
        this.movieID = movieID;
        this.movieType = movieType;
        this.mReleaseDate = mReleaseDate;
        this.mDuration = mDuration;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public String toString() {
        return ("Movie Details:\n" +
                "Movie Name: " + movieName +
                "\nMovie ID: " + movieID +
                "\nMovie Type: " + movieType +
                "\nRelease Date: " + mReleaseDate +
                "\nMovie Duration: " + mDuration);
    }
}
