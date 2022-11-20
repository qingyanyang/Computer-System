public class Bus{
    int busId;
    int capacity;
    int numberOfSeatAvaliable;
    Seat[] seatArr;
    boolean busIsAvaliable;

    public Bus() {
        capacity = 20;
        numberOfSeatAvaliable = capacity;
        seatArr = new Seat[capacity];
        for(int i = 0; i < capacity; i++){
            seatArr[i] = new Seat(i);
        }
        busIsAvaliable = true;
        busId = 0;
    }

    public Bus(int busId) {
        this();
        this.busId = busId;
    }
    public Bus(int busId, int capacity, int numberOfSeatAvaliable, Seat[] seatArr, boolean busIsAvaliable) {
        this.busId = busId;
        this.capacity = capacity;
        this.numberOfSeatAvaliable = numberOfSeatAvaliable;
        this.seatArr = seatArr;
        this.busIsAvaliable = busIsAvaliable;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfSeatAvaliable() {
        return numberOfSeatAvaliable;
    }

    public void setNumberOfSeatAvaliable(int numberOfSeatAvaliable) {
        this.numberOfSeatAvaliable = numberOfSeatAvaliable;
    }

    public Seat[] getSeatArr() {
        return seatArr;
    }

    public void setSeatArr(Seat[] seatArr) {
        this.seatArr = seatArr;
    }

    public boolean isBusIsAvaliable() {
        return busIsAvaliable;
    }

    public void setBusIsAvaliable(boolean busIsAvaliable) {
        this.busIsAvaliable = busIsAvaliable;
    }
    public void makeReservation(int busId, int seatId, String passengerName){
        if(this.busIsAvaliable && !seatArr[seatId].isReserved()){
            seatArr[seatId].reservation(seatId, passengerName);
            this.numberOfSeatAvaliable--;
        }else{
            System.out.println("failed!");
        }
    }
    public void cancelReservation(int busId, int seatId, String passengerName){
        if(this.isBusIsAvaliable() && seatArr[seatId].isReserved()){
            if(seatArr[seatId].getPassengerName().equals(passengerName)){
                seatArr[seatId].setReserved(false);
                seatArr[seatId].setPassengerName("empty");
                this.numberOfSeatAvaliable++;
            }
        }
    }
    public void printInfo(){
        for(int i = 0; i < 20; i++){
            System.out.print(seatArr[i].getPassengerName());
            if(i == 3 || i == 7 || i == 11){
                System.out.println("");
            }
        }
    }
}
