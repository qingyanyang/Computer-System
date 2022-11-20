class Rectangle{
    //create a method to caculate area
    public int area(int width, int height){
        int rectangleArea = width * height;
        return rectangleArea;
    }
    //create a method to display output content
    public void display(int width, int height){
        if((width <= 10*10*10 && width >= 1) && (height <= 10*10*10 && height >= 1))
        System.out.println("\n" + "Output: " + "\n" + width + " " + height);
    }
}