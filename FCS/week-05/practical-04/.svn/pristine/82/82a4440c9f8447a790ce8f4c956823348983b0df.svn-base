import java.util.*;
class Computer extends Player {
    String[] move = {"Rock", "Scissors", "Paper"};
    //defualt constructor
    public Computer(){
        super();
    }
    @Override
    public void produceMove(){
        Random ran = new Random();
        int index = ran.nextInt(3);
        //get random move
        this.setMove(move[index]);
    }
    @Override
    public void performMove(){
        System.out.println("the move of computer is: " + this.getMove());
    }
}