class Main{
    public static void main(String[] args){
        //create new instance named triangle1 of Triangle class
        Triangle triangle1 = new Triangle("triangle", 3.5d);
        //call super class Mutator
        triangle1.setHeight(5.5d);
        System.out.println("base(cm): " + triangle1.base + " " + "height(cm): " + triangle1.getHeight());
        //call method in this class and get variables from super class
        double triangleArea = triangle1.area(triangle1.base, triangle1.getHeight());
        System.out.println("area of rectangle1(cm^2): " + triangleArea);

        System.out.println("\n" + "-------------" + "\n");

        //create new instance named rectangle1 of Rectangle class
        Rectangle rectangle1 = new Rectangle("rectangle");
        //call super class Mutator
        rectangle1.setWidth(3.4d);
        rectangle1.setHeight(5.5d);
        System.out.println("width(cm): " + rectangle1.getWidth() + " " + "height(cm): " + rectangle1.getWidth());
        //call method in this class and get variables from super class
        double rectangleArea = rectangle1.area(rectangle1.getWidth(), rectangle1.getHeight());
        System.out.println("area of rectangle1(cm^2): " + rectangleArea);

        System.out.println("\n" + "-------------" + "\n");

        //create new instance named circle1 of Circle class
        Circle circle1 = new Circle("circle");
        System.out.println("radius(cm): " + circle1.getRadius());
        //call method in this class and get variables from super class
        double circleArea = circle1.area(circle1.getRadius());
        System.out.println("area of circle1(cm^2): " + circleArea);
    }
}