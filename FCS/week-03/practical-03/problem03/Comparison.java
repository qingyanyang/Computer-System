import java.util.Scanner;
public class Comparison {
    public static int compare(int a, int b){
        if(a >= b){
            return a;
        }else{
            return b;
        }
    }
    public static int tryCatch(Scanner input){
        int num = 0;
        while(true){
            try{
                String inputString = input.next();
                num = Integer.parseInt(inputString);
                break;
            }catch (Exception e){
                System.out.println("Invalid input! Try again: ");
                input = new Scanner(System.in);
            }
        }
        return num;
    }
    public static void main(String[] args){
        int num01 = 0;
        int num02 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please, insert a number: ");
        num01 = tryCatch(input);
        System.out.println("Please, insert a number: ");
        num02 = tryCatch(input);
        System.out.println("The bigger number is " + compare(num01, num02));
    }

}
