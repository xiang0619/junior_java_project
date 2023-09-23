import java.util.ArrayList;

public class Hall {
    private String hallID;
    private int capacity;
    private ArrayList<Seat> seats;

    public Hall(){}
    
    public Hall(String hallID, int capacity, ArrayList<Seat> seats) {
        this.hallID = hallID;
        this.capacity = capacity;
        this.seats = seats;
    }

    public String getHallID() {
        return hallID;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
    public String getSeatsInfor(){
        String seatsInfor = "";
        
        int i = 1;
        
        for(Seat seat:seats){
            seatsInfor += seat.toString() + "    ";
            if(i % 12 == 0){
                seatsInfor += "\n";
            }
            i++;
        }
        
        return seatsInfor;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hall ID: " + hallID + ", Capacity: " + capacity;
    }
}
