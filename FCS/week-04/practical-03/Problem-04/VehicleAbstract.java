public abstract class VehicleAbstract{
    String color;
    int year;
    int numberGears;
    //defualt constructor
    public VehicleAbstract(){
        color = getColor();
        year = getYear();
        numberGears = getNumberGears();
    }
    //a method to display info
    public void display1(){
        System.out.println("color: " + getColor());
        System.out.println("year: " + getYear());
        System.out.println("number of Gears: " + getNumberGears());
    }
    //accessor to get color value
    public String getColor(){
        return this.color;
    }
    //accessor to get year value
    public int getYear(){
        return this.year;
    }
    //accessor to get numbers of gear
    public int getNumberGears(){
        return this.numberGears;
    }
    //mutator to set color
    public void setColor(String color){
        this.color = color;
    }
    //mutator to set year
    public void setYear(int year){
        this.year = year;
    }
    //mutator to set numbers of gear
    public void setNumberGears(int numberGears){
        this.numberGears = numberGears;
    }

}