import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Schedule {
    private Hall hall;
    private Movie movie;
    private LocalDateTime scheduleDate;
    private List<Seat> seats;

    public Schedule(Hall hall, Movie movie, LocalDateTime date) {
    this.hall = hall;
    this.movie = movie;
    this.scheduleDate = LocalDateTime.parse(date.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    this.seats = new ArrayList<>();
}

    Schedule(Hall hall1, Movie movie, Date scheduleDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Hall getHall() {
        return hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getScheduleDate() {
        return scheduleDate;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void displaySeats() {
        System.out.println("Available Seats for Schedule: " + scheduleDate);
        for (Seat seat : seats) {
            if (!seat.getSeatStatus()) {
                System.out.println("Seat ID: " + seat.getSeatID() + ", Price: " + seat.getPrice());
            }
        }
    }

    public boolean reserveSeat(String seatID) {
        for (Seat seat : seats) {
            if (seat.getSeatID().equals(seatID) && !seat.getSeatStatus()) {
                seat.reserveSeat();
                return true;
            }
        }
        return false;
    }
}
