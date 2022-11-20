import java.util.ArrayList;
public class RomanNumber {
    public static int romanToInt(String s){
        ArrayList<Integer> arrListInt = new ArrayList<Integer>();
        int len = s.length();
        int element = 0;
        int sum = 0;
        for(int i = len - 1; i >= 0; i--){
            char vector = s.charAt(i);
            switch(vector){
                case 'I':
                    element = 1;
                    break;
                case 'V':
                    element = 5;
                    break;
                case 'X':
                    element = 10;
                    break;
                case 'L':
                    element = 50;
                    break;
                case 'C':
                    element = 100;
                    break;
                case 'D':
                    element = 500;
                    break;
                case 'M':
                    element = 1000;
                    break;
            }
            arrListInt.add(element);
        }
        sum = arrListInt.get(0);
        for(int j = 0; j < len - 1; j++){
            if(arrListInt.get(j) <= arrListInt.get(j + 1)){
                sum += arrListInt.get(j + 1);
            }else{
                sum -= arrListInt.get(j + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
