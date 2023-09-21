public class Seat {
    private String seatID;
    private double price;
    private boolean seatStatus;
    private String seatIdentifier;

    public Seat(String seatID, double price,String seatIdentifier) {
        this.seatID = seatID;
        this.price = price;
        this.seatStatus = false;
        this.seatIdentifier = seatIdentifier;
    }
    

    public String getSeatID() {
        return seatID;
    }

    public double getPrice() {
        return price;
    }

    public boolean getSeatStatus() {
        return seatStatus;
    }

    public boolean reserveSeat() {
        if (!seatStatus) {
            seatStatus = true;
            return true;
        } else {
            seatStatus = false;
            return false;
        }
    }

    public void cancelReservation() {
        if (seatStatus) {
            seatStatus = false;
        }
    }

    public String toString() {
        return "Seat ID: " + seatID + ", Price: " + price + ", Occupied: " + seatStatus;
    }
}
