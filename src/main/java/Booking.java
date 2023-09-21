import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Booking {
    private String bookingId;
    private static String nextBookingId = "C0001";
    private Customer cust;
    private Ticket ticket;
    private Payment payment;
    private Receipt receipt;
    private LocalDateTime bookingDate;

    static {
        // Increment nextBookingId when the class is loaded
        int numericId = Integer.parseInt(nextBookingId.substring(1));
        numericId++;
        nextBookingId = "C" + String.format("%04d", numericId);
    }

    public Booking(Customer cust, Ticket ticket, Payment payment, LocalDateTime bookingDate, String movieName) {
        this.bookingId = nextBookingId;
        this.cust = cust;
        this.ticket = ticket;
        this.payment = payment;
        this.receipt = new Receipt(cust, movieName, payment, bookingDate); // Pass movieName here
        this.bookingDate = bookingDate;
    }
}

