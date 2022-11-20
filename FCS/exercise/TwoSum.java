import java.util.Arrays;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int len = nums.length;
        int[] indices = new int[2];
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if((nums[i] + nums[j]) == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] indices = twoSum(nums, 9);
        System.out.println(Arrays.toString(indices));
        int[] nums1 = {3,2,4};
        int[] indices1 = twoSum(nums1, 6);
        System.out.println(Arrays.toString(indices1));
    }
}
