class Circle extends Shape{
    String shape;
    //constructor without parameter
    public Circle(){
        super(5.5d);
        shape = "triangle";
    }
    //constructor with parameter
    public Circle(String shape){
        super(5.5d);
        this.shape = shape;
        System.out.println("shape: " + this.shape);
    }

    //create method to calculate area
    public double area(double radius){
        double circleArea = 3.14 * radius * radius;
        return circleArea;
    }
}