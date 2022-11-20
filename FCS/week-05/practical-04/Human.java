import java.util.Scanner;
class Human extends Player {
    //defualt constructor
    public Human(){
        super();
    }
    @Override
    public void produceMove(){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please type one of the elements: Rock, Paper or Scissors");
        String inputText = input.next();
        //create object to call method
        BlurryMatch match1 = new BlurryMatch();
        String moveHuman = match1.blurryMatch(inputText);
        this.setMove(moveHuman);
    }
    @Override
    public void performMove(){
        System.out.println("your move is: " + this.getMove());
    }
    /*test
    public static void main(String[] args){
        Human a = new Human();
        a.produceMove();
        a.performMove();
    }*/
}