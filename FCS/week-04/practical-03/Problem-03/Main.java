class Main{
    public static void main(String[] args){
        RectangleArea area2 = new RectangleArea();
        area2.read_input();//call non-static read_input method in RectangleArea
        Rectangle rec1 =  new Rectangle();
        rec1.display(area2.width, area2.height);//call display method in Rectangle
        area2.display(area2.width, area2.height);//call  display method in RectangleArea
    }
}