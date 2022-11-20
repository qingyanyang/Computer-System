import java.io.*;
import java.util.Scanner;
class BlurryMatch{
    //a method to do blur matching
    public String blurryMatch(String inputText){
        String move = "";
        boolean status1 = true, status2 = true, status3 = true;
        //list of passibility
        String [][] rock = {{"R","K"}, {"R","k"}, {"r","K"}, {"r","k"}};
        String [][] scissors = {{"S","R"}, {"S","r"}, {"s","R"}, {"s","r"}};
        String [][] paper = {{"P","R"}, {"P","r"}, {"p","R"}, {"p","r"}};
        //checking
        for(int i = 0; i < rock.length; i++){
            //meet 2 charaters contained at the same time
            String rockString1 = rock[i][0];
            String rockString2 = rock[i][1];
            status1 = inputText.contains(rockString1) && inputText.contains(rockString2);

            String scissorsString1 = scissors[i][0];
            String scissorsString2 = scissors[i][1];
            status2 = inputText.contains(scissorsString1) && inputText.contains(scissorsString2);

            String paperString1 = paper[i][0];
            String paperString2 = paper[i][1];
            status3 = inputText.contains(paperString1) && inputText.contains(paperString2);
            //only one is ture
            if(status1){
                move = "Rock";
                break;
            }
            if(status2){
                move = "Scissors";
                break;
            }
            if(status3){
                move = "Paper";
                break;
            }
        }
        //screen out invalid input
        if((move != "Rock") && (move != "Scissors") && (move != "Paper")){
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            System.out.print("try again: ");
            inputText = input.next();
            move = blurryMatch(inputText);//start loop until meet requirement
        }
        return move;
    }
    /*test
    public static void main(String[] args){
        BlurryMatch a = new BlurryMatch();
        String b = a.blurryMatch("n");
        System.out.println(b);
    }*/
}
