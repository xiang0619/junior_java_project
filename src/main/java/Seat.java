public class Seat {
    private String seatID;
    private boolean seatStatus;
    
    public Seat(){};
    
    public Seat(String seatID, boolean status) {
        this.seatID = seatID;
        this.seatStatus = status;
    }

    public String getSeatID() {
        return seatID;
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

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public void setSeatStatus(boolean seatStatus) {
        this.seatStatus = seatStatus;
    }
    
    public void cancelReservation() {
        if (seatStatus) {
            seatStatus = false;
        }
    }

}
