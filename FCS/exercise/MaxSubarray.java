import java.util.Arrays;
public class MaxSubarray {
    public static int maxSubArray(int[] num){
        int len = num.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            int max = num[i];
            for(int j = i; j < len; j++){
                sum += num[j];
                if(sum > max){
                    max = sum;
                }
            }
            sum = 0;
            num[i] = max;
        }
        Arrays.sort(num);
        return num[len-1];
    }

    public static void main(String[] args) {
        int[] num = {5,4,-1,7,8};
        System.out.println(maxSubArray(num));
    }
}
