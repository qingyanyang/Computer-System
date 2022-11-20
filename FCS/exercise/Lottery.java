import java.util.Random;
import java.util.Scanner;
public class Lottery {
    public static void main(String[] args) {
        Random ran = new Random();
        int lottery = ran.nextInt(100);
        int getInput;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a two-digit integer: ");
        while(true){
            try{
                getInput = input.nextInt();
                if(getInput > 99 || getInput < 10){
                    float f = 1.0f /0;
                }
                break;
            }catch(Exception e){
                System.out.println("Invalid! Please try again: ");
                input = new Scanner(System.in);
            }
        }
        int digitLottery1 = lottery % 10;
        int digitLottery2 = (lottery - digitLottery1) / 10;
        int digitGetInput1 = getInput % 10;
        int digitGetInput2 = (getInput - digitLottery1) / 10;
        if(lottery == getInput){
            System.out.println("congratulations! You have won $10,000!");
        } else if(digitLottery1 == digitGetInput2
                && digitLottery2 == digitGetInput1){
            System.out.println("congratulations! You have won $3,000!");
        }else if(digitLottery1 == digitGetInput1
                || digitLottery1 == digitGetInput2
                || digitLottery1 == digitGetInput2
                || digitLottery2 == digitGetInput1){
            System.out.println("congratulations! You have won $1,000!");
        }else{
            System.out.println("Sorry, you lost.");
        }
        System.out.println("rewards number: " + lottery);
    }
}
