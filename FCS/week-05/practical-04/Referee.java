import java.util.Scanner;
import java.io.*;
//import java.util.InputMismatchException;
class Referee{
    String tryAgain = "";
    String yAnswer = "";
    int answer = 0;
    int i = 1, j = 0, k = 0;
    float f = 0.0f;
    //design menu for the game
    public void menu(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Welcome to Rock! Paper! Scissors!");
        System.out.println("1) Read rule");
        System.out.println("2) Let's play!");
        System.out.println("3) exit game");
        //capture invalid input
        while(true){
            try{
                answer = input.nextInt(4);//input should under 4
                f = 1 / answer;//input cannot be 0
                break;
            }catch(Exception e){
                System.out.print("invalid input! Try again: ");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        }
        //rule about the game
        if(answer == 1){
            System.out.println("\n" + "rule: " + "\n");
            System.out.println("you are asked to input one elements of the game: rock, paper and scissors;");
            System.out.println("The other element is from computer randomly.");
            System.out.println("The outcome of the game is determined by 3 simple rules:" + "\n");
            System.out.println("* Rock wins against scissors." + "\n" + "* Scissors win against paper." + "\n" + "* Paper wins against rock." + "\n");
            System.out.println("1) exit game  2) continue play");
            //capture invalid input
            while(true){
                try{
                    answer = input.nextInt(3);//input should under 3
                    f = 1 / answer;//input cannot be 0
                    break;
                }catch(Exception e){
                    System.out.print("invalid input! Try again: ");
                    input = new Scanner(System.in).useDelimiter("\n");
                }
            }
        }
        //start game
        if(answer == 2){
            do{
                Player human1 = new Human();//create object to call overrided methods in sub class Human
                human1.produceMove();
                human1.performMove();
                String move1 = human1.getMove();

                Player computer1 = new Computer();//create object to call overrided methods in sub class Computer
                computer1.produceMove();
                computer1.performMove();
                String move2 = computer1.getMove();
                //call judge method to judge who wins the game
                String result = this.judge(move1, move2);
                if(move1.equals(result)){
                    System.out.println("you won the game!");
                    j++;//accumulate won times
                }
                if(move2.equals(result)){
                    System.out.println("computer won the game!");
                }

                System.out.println("Would you like to play again? (y/n)");// another turn
                //capture invalid input
                while(true){
                    try{
                        tryAgain = input.next();
                        boolean meet = tryAgain.equals("y") || tryAgain.equals("n");
                        if(tryAgain.equals("y"))
                            i++;//accumulate play times
                        if(tryAgain.equals("n")){
                            System.out.println("you totally played " + i + " times");
                            System.out.println("won: " + j + " times");
                            System.out.println("lost: " + (i-j-k) + " times");
                            System.out.println("draw: " + k + " times");
                        }
                        if(!meet)
                            f = 1 / 0;
                        break;
                    }catch(Exception e){
                        System.out.print("invalid input! Try again: ");
                        input = new Scanner(System.in).useDelimiter("\n");
                    }
                }
            }while(tryAgain.equals("y"));//looping when user choose y
        }
    }

    //method to judge which element is bigger
    public String judge(String move1, String move2){
        String winner = "", text = "";
        if(move1 == move2){
            text = "you two reached a draw!";
            k++;//accumulate draw times
            System.out.println(text);
            return text;
        }else if((move1.equals("Rock") && move2.equals("Paper")) || (move2.equals("Rock") && move1.equals("Paper"))){
            winner = "Paper";
            return winner;
        }else if((move1.equals("Rock") && move2.equals("Scissors")) || (move2.equals("Rock") && move1.equals("Scissors"))){
            winner = "Rock";
            return winner;
        }else{
            winner = "Scissors";
            return winner;
        }
    }

}