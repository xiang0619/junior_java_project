import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class Schedule {
    private Hall hall;
    private Movie movie;
    private String startTime;
    private String endTime;

    public Schedule(){}
    
    public Schedule(Hall hall, Movie movie, String startTime, String endTime) {
        this.hall = hall;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Hall getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }
    
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
