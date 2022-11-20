//class Bicycle achieve interface and inheritate abstract class
class Bicycle extends VehicleAbstract implements Vehicle{
    boolean is_serviced;
    String inDate;
    String outDate;
    String serviceResponsible;
    //defulat constructor
    public Bicycle(){
        super();
        is_serviced = true;
        inDate = "23/03/2022";
        outDate = "27/03/2022";
        serviceResponsible = "nice service";
    }
    //method to get service info
    public void checkoutService(){
        System.out.println("the bike has been service? " + getIs_serviced());
        System.out.println("the date in: " + getInDate());
        System.out.println("the date out: " + getOutDate());
        System.out.println("comment for the service: " + getServiceResponsible());
    }
    //accessors for each attribute
    public boolean getIs_serviced(){
        return this.is_serviced;
    }
    public String getInDate(){
        return this.inDate;
    }
    public String getOutDate(){
        return this.outDate;
    }
    public String getServiceResponsible(){
        return this.serviceResponsible;
    }
    //mutators for each attribute
    public void setIs_serviced(boolean is_serviced){
        this.is_serviced = is_serviced;
    }
    public void setInDate(String inDate){
        this.inDate = inDate;
    }
    public void setOutDate(String outDate){
        this.outDate = outDate;
    }
    public void setServiceResponsible(String serviceResponsible){
        this.serviceResponsible = serviceResponsible;
    }
    //write the interface method changeGear
    public void changeGear(double price1){
        System.out.println("service: gear change ✔ ");
        System.out.println("cost($): " + price1);
    }
    //overload it
    public void changeGear(String action){
        System.out.println("no need for gear change service ");
    }
    //write the interface method
    public void checkBreak(double price2){
        System.out.println("service: break check ✔ ");
        System.out.println("cost($): " + price2);
    }
    //overload it
    public void checkBreak(String action){
        System.out.println("no need for break check service");    }
}