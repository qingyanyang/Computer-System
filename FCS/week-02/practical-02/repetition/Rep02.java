public class Rep02 {
    public static void main(String [] arg){
        int num = 0;
        String symbol = "";
        int sum = 0;
        int ave = 0;
        for(int i = 0; i < 10; i++){
            num = (int)(Math.random()*20);
            sum += num;
            for(int j = 0; j < num; j++){
                symbol += "*";
            }
            System.out.println("Number (" + num + "): " + symbol);
            symbol = "";
        }
        ave = Math.round((float)sum/10);
        for(int k = 0; k < ave; k++){
            symbol += "*";
        }
        System.out.println("Average (" + ave + "): " + symbol);
    }
}
