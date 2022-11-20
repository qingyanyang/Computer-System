import java.util.Scanner;
public class PrimeNumber {
    public static boolean checkPrime(int num){
        if(num < 2){
            return false;
        }else if (num == 2){
            return true;
        }else{
            for(int i = 2; i < num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[]args){
        int num = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please, insert a number: ");
        String getWord = input.next();
        while(true){
            try{
                num = Integer.parseInt(getWord);
                break;
            }catch(Exception e){
                System.out.println("Invalid input! Try again: ");
                getWord = input.next();
            }
        }
        if(checkPrime(num)){
            System.out.println("Your number is prime");
        }else{
            System.out.println("Your number is not prime");
        }
    }
}
