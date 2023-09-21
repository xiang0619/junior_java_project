public class Hall {
    private String hallID;
    private int capacity;

    public Hall(String hallID, int capacity) {
        this.hallID = hallID;
        this.capacity = capacity;
    }

    public String getHallID() {
        return hallID;
    }

    public int getCapacity() {
        return capacity;
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
