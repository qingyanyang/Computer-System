class PhysicalBook extends Book {
    int shelf, aisle, floor;
    String type;
    //defualt constructor
    public PhysicalBook(){
        super();
        shelf = 1;
        aisle = 2;
        floor = 3;
        type = "Physical Book";
    }
    //create constractor with parameters and call super class constractor
    public PhysicalBook(int shelf, int aisle, int floor){
        super(2021);
        this.shelf = shelf;
        this.aisle = aisle;
        this.floor = floor;
    }
    //create a method to display info
    public void displayBookLocation(){
        System.out.println("shelf: " + this.shelf);
        System.out.println("aisle: " + this.aisle);
        System.out.println("floor: " + this.floor);
    }
    //accessor
    public String getType(){
        return this.type;
    }
    //mutator
    public void setType(String type){
        this.type = type;
    }
}