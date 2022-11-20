import java.util.Scanner;
//inheritate Rectangle class
class RectangleArea extends Rectangle {

    int width, height;

    public void read_input(){
        //get users input
        Scanner input = new Scanner(System.in);
        System.out.println("Input: ");
        //get two string input
        String inputText1 = input.next(), inputText2 = input.next();

        //create object call numberScreen method from other class to screen int number ∈ [1,1000]
        NumberScreen number = new NumberScreen();
        number.numberScreen(inputText1, inputText2);
        //call variable number3 and number4 from NumberScreen and attribute them to variables in this class
        this.width = number.number3;
        this.height = number.number4;
    }
    public void display(int width, int height){
        //RectangleArea area1 = new RectangleArea();
        int rectangleArea = this.area(width, height);// call super class area method
        if((width <= 10*10*10 && width >= 1) && (height <= 10*10*10 && height >= 1))
        System.out.println(rectangleArea);
    }
}