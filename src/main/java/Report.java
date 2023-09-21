import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    private LocalDateTime reportCreatedDate;
    private String bookingID;
    private double totalSales;

    public Report(String bookingID, double totalSales) {
        this.bookingID = bookingID;
        this.totalSales = totalSales;

        // Set report created date to current date and time
        reportCreatedDate = LocalDateTime.now();
    }

    public double getTotalSales() {
        return totalSales;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String displayReport() {
        String reportDetails = "Report Details:\n" +
                "Report Created Date: " + reportCreatedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n" +
                "Booking ID: " + getBookingID() + "\n" +
                "Total Sales: RM" + getTotalSales();

        return reportDetails;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportCreatedDate=" + reportCreatedDate +
                ", bookingID='" + bookingID + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
