import java.util.Random;
public class RandomNumber {
    public static void main(String[] args) {
        int sum = 0;
        int ranNum = 0;
        int ranNumMath = 0;
        int sumMath = 0;
        Random ran = new Random();
        for(int i = 0; i < 10; i++){
            ranNum = ran.nextInt(100);
            System.out.print(ranNum + " ");
            sum += ranNum;
            ranNumMath = 100 + (int) (Math.random() * 100);
            System.out.print(ranNumMath + " ");
            sumMath += ranNumMath;
        }
        System.out.println("\n" + "mean: " + (float)sum/10);
        System.out.println("\n" + "mean: " + (float)sumMath/10);

    }
}
