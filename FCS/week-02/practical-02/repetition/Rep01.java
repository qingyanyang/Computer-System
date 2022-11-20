public class Rep01 {
    public static void main(String [] arg){
        int num = 0;
        String symbol = "";
        for(int i = 0; i < 10; i++){
            num = (int)(Math.random()*20);
            for(int j = 0; j < num; j++){
                symbol += "*";
            }
            System.out.println("Number (" + num + "): " + symbol);
            symbol = "";
        }
    }
}
