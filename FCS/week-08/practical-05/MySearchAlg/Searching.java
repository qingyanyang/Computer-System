public class Searching {
    public static int linear(int value, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(value == arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static int binary(int value, int[] arr, int start, int end){
        int mid = start + (end - start)/2;
        if(end < start){
            return -1;
        }else if (value == arr[mid]){
            return mid;
        }else if(value > arr[mid]){
            return binary(value,arr,mid+1,end);
        }else{
            return binary(value,arr,start,mid-1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,9,6,7,0,44,63,90,45};
        int[] arrSorted = {0,2,3,4,6,7,9,44,45,63,90};
        System.out.println(binary(9,arrSorted,0,10));
        System.out.println(linear(9,arr));
    }
}
