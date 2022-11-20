class Rectangle extends Shape{
    String shape;
    //constructor without parameter
    public Rectangle(){
        super(0);
        shape = "rectangle";
    }
    //constructor with parameter
    public Rectangle(String shape){
        super(0);
        this.shape = shape;
        System.out.println("shape: " + this.shape);
    }
    //create method to calculate area
    public double area(double width, double height){
        double rectangleArea = width * height;
        return rectangleArea;
    }
}