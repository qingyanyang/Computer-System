import java.util.Scanner;
public class Interface {
    //check if string is number
    public static int checkNumber(Scanner input){
        while(true){
            try{
                String num = input.next();
                int numInt = Integer.parseInt(num);
                return numInt;
            }catch(Exception e){
                System.out.println("invalid input! please enter number:");
                input = new Scanner(System.in);
            }
        }
    }
    public static void main(String[] args){
        String answer = "";
        //iteration if user wants to play again and again
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome dear user!\n\n" + "Would you like to:\n" + "a) sum again\nb) exit\nOption:");
            answer = input.next();
            while(!answer.equals("b") && !answer.equals("a")){
                System.out.println("invalid input! Please enter \"a\" or \"b\".");
                input = new Scanner(System.in);
                answer = input.next();
            }
            if(answer.equals("a")) {
                System.out.println("Please, insert the first number:");
                input = new Scanner(System.in);
                int num01 = checkNumber(input);
                System.out.println("Please, insert the second number:");
                input = new Scanner(System.in);
                int num02 = checkNumber(input);
                System.out.println("Thank you for your enquiry, the sum between " + num01 + " and " + num02 + " is " + (num01 + num02));
            }else{
                System.out.println("Thank you! Have a good day.");
            }
        }while(!answer.equals("b"));
    }
}

