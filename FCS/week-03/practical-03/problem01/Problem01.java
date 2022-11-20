import java.util.Arrays;
public class Problem01 {
    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void printArray(String[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void printArray(float[] array){
        System.out.println(Arrays.toString(array));
    }
    public static int[] reverseArray(int[] array){
        int size = array.length;
        int[] arrNew = new int[size];
        for(int i = 0,j = size - 1; i < size; i++,j--){
            arrNew[i] = array[j];
        }
        return arrNew;
    }
    public static String[] reverseArray(String[] array){
        int size = array.length;
        String[] arrNew = new String[size];
        for(int i = 0,j = size - 1; i < size; i++,j--){
            arrNew[i] = array[j];
        }
        return arrNew;
    }
    public static float[] reverseArray(float[] array){
        int size = array.length;
        float[] arrNew = new float[size];
        for(int i = 0,j = size - 1; i < size; i++,j--){
            arrNew[i] = array[j];
        }
        return arrNew;
    }
    public static void main(String[] args){
        int [] array = {1,2,3,4};
        printArray(array);
        printArray(reverseArray(array));
    }
}
