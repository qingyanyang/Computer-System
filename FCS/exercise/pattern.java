public class pattern {
    public static void displayPattern(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n + 1 ; j > 0; j--){
                if(j <= i){
                    System.out.print(j);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        displayPattern(4);
    }
}
