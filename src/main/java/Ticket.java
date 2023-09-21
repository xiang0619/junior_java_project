import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String ticketID;
    private double price;
    private String seatID;
    private String hallID;
    private LocalDateTime reservationDateTime;
    private int quantity;

    private static int ticketCounter = 1;

    public Ticket(String seatID, double price, String hallID, LocalDateTime reservationDateTime, int quantity) {
        this.ticketID = generateTicketID();
        this.seatID = seatID;
        this.price = price;
        this.hallID = hallID;
        this.reservationDateTime = reservationDateTime;
        this.quantity = quantity;
    }

    private String generateTicketID() {
        // Logic to generate a unique ticket ID
        // Example: "T0001", "T0002", etc.
        String formattedCounter = String.format("%04d", ticketCounter++);
        return "T" + formattedCounter;
    }

    public String getTicketID() {
        return ticketID;
    }
    
    public int getQuantity(){
    	return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatID() {
        return seatID;
    }

    public String getHallID() {
        return hallID;
    }

    public LocalDateTime getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(LocalDateTime reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = reservationDateTime.format(formatter);

        return "Ticket ID: " + ticketID +
               "\nPrice: " + price +
               "\nSeat ID: " + seatID +
               "\nHall ID: " + hallID +
               "\nReservation Date and Time: " + formattedDateTime;
    }
}
