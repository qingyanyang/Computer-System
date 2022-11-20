class Triangle extends Shape{
    String shape;
    double base;
    //constructor without parameter
    public Triangle(){
        super(0);
        shape = "triangle";
        base = 3.4d;
    }
    //constructor with parameter
    public Triangle(String shape, double base){
        super(0);
        this.shape = shape;
        this.base = base;
        System.out.println("shape: " + this.shape);
    }
    //create method to calculate area
    public double area(double base, double height){
        double triangleArea = (base * height) / 2;
        return triangleArea;
    }
}