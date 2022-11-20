public class RemoveDuplicate {
    public static int removeDuplicate(int[] arr){
        int count = 0;
        int len = arr.length;
        int j = 0, i = 0;
        for(int element : arr){
            System.out.print(element + " ");
        }
        System.out.println("");
        for(i = 0; i < len - 1; i++){
            if(arr[i] == arr[i + 1]){
                count++;
            }else{
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[i];
        while(count < len){
            arr[++j] = 0;
            len--;
        }
        for(int element2 : arr){
            System.out.print(element2 + " ");
        }
        System.out.println("");
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate(arr));
    }
}
