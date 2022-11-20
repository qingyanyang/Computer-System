import java.util.Arrays;
import java.util.ArrayList;
public class Sort {
    public static int[] bubble(int[] arr){
        int len = arr.length;
        int[] arrSorted = arr.clone();
        boolean mark = true;
        for(int j = 0; j < len - 1; j++){
            for(int i = 0; i < len - j - 1; i++){
                if(arrSorted[i] > arrSorted[i+1]){
                    int temp = arrSorted[i];
                    arrSorted[i] = arrSorted[i+1];
                    arrSorted[i+1] = temp;
                    mark = false;
                }
            }
            if(mark){
                return arrSorted;
            }
        }
        return arrSorted;
    }
    public static int[] insertion(int[] arr){
        int len = arr.length;
        int[] arrSorted = arr.clone();
        for(int i = 1; i < len; i++){
            int key = arrSorted[i];
            int j = i;
            while(j >= 1 && key < arrSorted[j - 1]){
                arrSorted[j] = arrSorted[j-1];
                j--;
            }
            arrSorted[j] = key;
        }
        return arrSorted;
    }
    public static int[] selection(int[] arr){
        int len = arr.length;
        int[] arrSorted = arr.clone();
        for(int i = 0; i < len; i++){
            int minIndex = i;
            for(int j = i + 1; j < len; j++){
                if(arrSorted[minIndex] > arrSorted[j]){
                    minIndex = j;
                }
            }
            int temp = arrSorted[minIndex];
            arrSorted[minIndex] = arrSorted[i];
            arrSorted[i] = temp;
        }
        return arrSorted;
    }
    public static int[] merge(int[] arr){
        int len = arr.length;
        int[] arrSorted = arr.clone();
        if(len<2){
            return arrSorted;
        }else{
            int[] arrLeft = makeArray(0,(len/2) - 1,arrSorted);
            int[] arrRight = makeArray(len/2,len-1,arrSorted);
            return mergeMerge(merge(arrLeft), merge(arrRight));
        }
    }
    public static int[] makeArray(int start, int end, int[] arr){
        int len = end - start + 1;
        int[] arrNew = new int[len];
        int j = 0;
        for(int i = start; i <= end; i++){
            arrNew[j] = arr[i];
            j++;
        }
        return arrNew;
    }
    public static int[] mergeMerge(int[] arr01, int[] arr02){
        int len01 = arr01.length;
        int len02 = arr02.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arrNew = new int[len01+len02];
        while(len01>i && len02>j){
            if(arr01[i] < arr02[j]){
                arrNew[k] = arr01[i];
                i++;
            }else{
                arrNew[k] = arr02[j];
                j++;
            }
            k++;
        }
        while(len01>i){
            arrNew[k++] = arr01[i++];
        }
        while(len02>j){
            arrNew[k++] = arr02[j++];
        }
        return arrNew;
    }

    public static int[] quick(int[] arr){
        int len = arr.length;
        int[] arrSorted = arr.clone();
        if(len < 2){
            return arrSorted;
        }else{
            int pivotal = arrSorted[0];
            int[] smaller = makeSmaller(pivotal,arrSorted);
            int[] bigger = makeBigger(pivotal,arrSorted);
            return concatenate(quick(smaller),pivotal,quick(bigger));
        }
    }
    public static int[] makeSmaller(int pivotal, int[] arr){
        int len = arr.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(arr[i]<pivotal){
                arrayList.add(arr[i]);
            }
        }
        int[] arrNew = new int[arrayList.size()];
        for(int j = 0; j < arrayList.size(); j++){
            arrNew[j] = arrayList.get(j);
        }
        return arrNew;
    }
    public static int[] makeBigger(int pivotal, int[] arr){
        int len = arr.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(arr[i]>pivotal){
                arrayList.add(arr[i]);
            }
        }
        int[] arrNew = new int[arrayList.size()];
        for(int j = 0; j < arrayList.size(); j++){
            arrNew[j] = arrayList.get(j);
        }
        return arrNew;
    }
    public static int[] concatenate(int[] arr01, int pivotal, int[] arr02){
        int len01 = arr01.length;
        int len02 = arr02.length;
        int[] arrNew = new int[len01+len02+1];
        for(int i = 0; i < len01+len02+1; i++){
            if(i < len01){
                arrNew[i]=arr01[i];
            }else if(i == len01){
                arrNew[i]=pivotal;
            }else{
                arrNew[i]=arr02[i-len01-1];
            }
        }
        return arrNew;
    }
    public static void main(String[] args){
        int[] arr = {4,6,2,8,1,3,0};
        System.out.println(Arrays.toString(bubble(arr)));
        System.out.println(Arrays.toString(insertion(arr)));
        System.out.println(Arrays.toString(selection(arr)));
        System.out.println(Arrays.toString(merge(arr)));
        System.out.println(Arrays.toString(quick(arr)));
    }
}
