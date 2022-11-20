import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] arr, int increment){
        //convert arr to string
        String combineStr = "";
        for(int element : arr)
            combineStr += element;
        //convert string to int
        int combineInt = Integer.parseInt(combineStr);
        //add increment
        int sum = combineInt + increment;
        //count digits
        int tmp = sum;
        int count = 0;
        while(tmp > 0){
            tmp = tmp / 10;
            count++;
        }
        //attribute every digit to a new array
        int[] newArr = new int[count];
        int tmp2 = sum;
        while(count > 0){
            newArr[count - 1] = tmp2 % 10;
            tmp2 = tmp2 / 10;
            count--;
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9};
        int[] arrNew = plusOne(arr,1);
        System.out.println(Arrays.toString(arrNew));
    }
}
