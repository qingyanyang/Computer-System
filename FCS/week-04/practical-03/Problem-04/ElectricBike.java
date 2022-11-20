//inheritate class Bicycle
class ElectricBike extends Bicycle{
    String battery;
    //defualt constructor and call superclass constructor
    public ElectricBike(){
        super();
        battery = "out of power";
    }
    //method chargeBike
    public void chargeBike(){
        System.out.println("service: battery charge ✔" + "\n" + "cost($): free");
    }
    public void chargeBike(String action){
        System.out.println("service: battery charge ✖ ");
    }
    //method to display
    public void display4(){
        System.out.println("battery condition: " + this.battery);
    }
}