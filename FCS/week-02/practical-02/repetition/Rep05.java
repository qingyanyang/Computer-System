public class Rep05 {
    public static void main(String[] args){
        int num = 0;
        int mark = 0;
        String symbol = "";
        for(int j = 0; j < 10; j++){
            num = (int)(Math.random() * 20);
            if(num <= 5) {
                mark = 1;
            }else if(num <= 10) {
                mark = 2;
            }else if(num <= 15) {
                mark = 3;
            }else if(num <= 20) {
                mark = 4;
            }
            for(int i = 0; i < num; i++){
                switch (mark){
                    case 1:
                        symbol += "o";
                        break;
                    case 2:
                        symbol += "x";
                        break;
                    case 3:
                        symbol += "s";
                        break;
                    case 4:
                        symbol += "*";
                        break;
                }
            }
            System.out.println("Number (" + num + "): " + symbol);
            symbol = "";
        }
    }
}
