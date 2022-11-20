import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        //get users' valide input
        int inputText = 0;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Please enter a positive integer: ");
        while(true){
            try{
                inputText = input.nextInt();
                break;
            }catch(Exception e){
                System.out.print("Invalid input! Try again: ");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        }
        //create object to revoke nextHappyNumber()
        Main m1 = new Main();
        System.out.println("Its next smallest happy number is: " + m1.nextHappyNum(inputText));
        //revoke decodeString()
        String encoded = "2[b3[a]2[bc]]ef";
        System.out.println("Encoded string: " + encoded);
        String decoded = m1.decodeString(encoded);
        System.out.println("Decoded string: " + decoded);
    }
    //method to get next HappyNumber
    public int nextHappyNum(int num){
        num++;
        boolean b = checkHappyNumber(num);
        if(b){
            int happyNum = num;
            return happyNum;
        }else{
            int happyNum = nextHappyNum(num);
            return happyNum;
        }
    }
    //method to check happyNumber
    public boolean checkHappyNumber(int num){
        int sum = 0;
        while(num > 0){
            int i = num % 10;
            num = (num - i) / 10;
            sum += (int)Math.pow(i, 2);
        }
        if(sum == 1){
            return true;
        }else if(sum == 4){
            return false;
        }else{
            boolean b = checkHappyNumber(sum);
            return b;
        }
    }
    //method to decode encode string
    public String decodeString(String s){
        Formatting i = new Formatting();
        ArrayList<String> listString = new ArrayList<String>();
        //revoke format() to get element format like 123@[abc] from same class
        listString = i.format(s);
        String origin = "";
        //add content from [""] with its constant times, e.g.add "abc" for 123 times
        for(int j = 0; j < listString.size(); j++){
            //divide constant 123 and [abc] by "@"
            String [] arr = listString.get(j).split("@", 2);
            int constant = Integer.parseInt(arr[0]);
            //get content in [ ]
            String content = arr[1].substring(1, arr[1].length() - 1);
            //recursion
            while(constant > 0){
                if(!content.contains("[") && !content.contains("]")){
                    origin += content;
                }else{
                    origin += decodeString(content);
                }
                constant--;
            }
        }
        return origin;
    }
}