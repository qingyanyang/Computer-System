//inheritate class Bicycle
class Hibrid extends Bicycle{
    String suspension;
    //defualt constructor and call superclass constructor
    public Hibrid(){
        super();
        suspension = "works well";
    }
    //method to display info
    public void display4(){
        System.out.println("suspension condition: " + this.suspension);
    }
}