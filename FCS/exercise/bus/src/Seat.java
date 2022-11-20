public class Seat {
    int seatId;
    boolean isReserved;
    String passengerName;

    public Seat() {
        isReserved = false;
        passengerName = "Empty";
        seatId = 0;
    }

    public Seat(int seatId) {
        this.seatId = seatId;
    }

    public Seat(int seatId, boolean isReserved, String passengerName) {
        this.seatId = seatId;
        this.isReserved = isReserved;
        this.passengerName = passengerName;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public void reservation(int seatId, String passengerName){
        if(this.isReserved){
            System.out.println("sorry this seat is reserved.");
        }else{
            this.isReserved = true;
            this.passengerName = passengerName;
        }
    }
    public void cancelReservation(int seatId){
        if(this.isReserved){
            this.isReserved = false;
            this.passengerName = "empty";
        }else{
            System.out.println("this seat is not reserved.");
        }
    }

}
