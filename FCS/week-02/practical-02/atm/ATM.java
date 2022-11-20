import java.util.Scanner;
public class ATM {
    public static String run(int num){
        int x = num / 50;
        int y = (num % 50) % 20;
        //call back one 50 value
        int z = (num % 50 + 50) % 20;
        if(y == 0){
            return "Here is " + (num % 50) / 20 + " $20 notes and " + x + " $50 notes.";
        }else if(z == 0){
            return "Here is " +  (num % 50 + 50) / 20 + " $20 notes and " + (x - 1) + " $50 notes.";
        }else{
            return "Sorry, the value you input cannot be withdraw.";
        }
    }
    public static void main(String[]args){
        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the amount of money you want to withdraw:");
        String amount = input.next();
        //check if the string input is number or not
        while(true){
            try{
                num = Integer.parseInt(amount);
                break;
            }catch(Exception e){
                System.out.println("invalid input! please enter integer:");
                input = new Scanner(System.in);
            }
        }
        System.out.println(run(num));
    }
}
