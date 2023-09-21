import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private String receiptID;
    private LocalDateTime receiptDateCreated;
    private Customer customer;
    private Ticket ticket;
    private Payment payment;

    private static int receiptCounter = 1;

    public Receipt(Customer customer, String movieName, Payment payment, LocalDateTime reservationDateTime) {
        this.customer = customer;
        this.ticket = new Ticket("T0001", 25.00, "S1", reservationDateTime, 5); // Create a new Ticket object with the movie name
        this.payment = payment;

        // Generate receipt ID
        receiptID = generateReceiptID();

        // Set receipt date
        receiptDateCreated = LocalDateTime.now();
    }

    private String generateReceiptID() {
        // Logic to generate unique receipt ID
        // Example: "rcp001", "rcp002", etc.
        return "rcp" + String.format("%03d", generateReceiptNumber());
    }

    private int generateReceiptNumber() {
        return receiptCounter++;
    }

    // Rest of the class methods...
}
