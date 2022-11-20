import java.util.*;
import java.io.*;
import java.util.Arrays;
class Main{
	public static void main(String[] args){
		int [] array1 = {0, 9, 1, 2, 3, 6, 3};
		int num1 = 3;

		int [] array2 = {4, 68, 58, 77, 69, 90, 23};
		int num2 = 90;

		int [] array3 = {79, 24, 76, 34, 57, 32};
		int num3 = 4;
		// linearSearch algorithm testing
		LinearSearch linear1 = new LinearSearch();
		Stack<Integer> ans1Stack = new Stack<Integer>();
		int result2 = linear1.search(array2, num2);
		int result3 = linear1.search(array3, num3);
		linear1.display1(array1, num1, linear1.search1(array1, num1));
		linear1.display(array2, num2, result2);
		linear1.display(array3, num3, result3);
		ans1Stack.push(4);
		ans1Stack.push(6);
		int ans2 = Arrays.binarySearch(array2, num2);
		int ans3 = Arrays.binarySearch(array3, num3);
		System.out.println(test(ans1Stack, linear1.search1(array1, num1)));
		System.out.println(test(result2, ans2));
		System.out.println(test(result3, ans3));

		int [] array11 = {0, 1, 2, 3, 3, 6, 9};
		num1 = 3;

		int [] array22 = {4, 23, 58, 68, 69, 77, 90};
		num2 = 90;

		int [] array33 = {24, 32, 34, 57, 76, 79};
		num3 = 4;
		// binarySearch algorithm testing
		BinarySearch binary1 = new BinarySearch();
		Stack<Integer> ans11Stack = new Stack<Integer>();
		result2 = binary1.search2(array22, num2, 0, 6);
		result3 = binary1.search(array33, num3);
		binary1.display1(array11, num1, binary1.search1(array11, num1));
		binary1.display(array22, num2, result2);
		binary1.display(array33, num3, result3);
		ans11Stack.push(3);
		ans11Stack.push(4);
		ans2 = Arrays.binarySearch(array22, num2);
		ans3 = Arrays.binarySearch(array33, num3);
		System.out.println(test(ans11Stack, binary1.search1(array11, num1)));
		System.out.println(test(result2, ans2));
		System.out.println(test(result3, ans3));

		int [] array = {1, 5, 8, 12, 9, 7, -1};
		int ans = 3;
		int result11 = findMaxVal1(array);
		int result22 = findMaxVal2(array);
		int result33 = findMaxVal3(array);
		System.out.println(test(result11, ans));
		System.out.println(test(result22, ans));
		System.out.println(test(result33, ans));
	}
	//method to compare
	private static boolean test(int result, int ans){
		if(result == ans)
			return true;
		return false;
	}
	//method to compare Stack
	private static boolean test(Stack<Integer> result, Stack<Integer> ans){
		int h = result.size();
		int n = ans.size();
		if(h != n)
			return false;
		while(!result.isEmpty()){
			if(result.pop() != ans.pop())
				return false;
		}
		return true;
	}
	//method1 to find max element index
	private static int findMaxVal1(int array[]){
		int n = array.length;
		int j = 0;
		while(array[j + 1] > array[j]){
			j++;
		}
		return j;
	}
	//method2 to find max element index with selection sort algorithm
	private static int findMaxVal2(int array[]){
		int n = array.length;
		int maxIndex = 0;
		for(int i = 0; i < n; i++){
			if(array[maxIndex] < array[i + 1])
				maxIndex = i + 1;
			else
				break;
		}
		return maxIndex;
	}
	//method2 to find max element index with binary algorithm
	private static int findMaxVal3(int array[]){
		int n = array.length - 1;
		int startIndex = 0;
		int endIndex = n;
		while(startIndex <= endIndex){
			int mid = startIndex + Math.round((endIndex - startIndex) / 2.0f);
			if(array[mid] > array[mid - 1] && array[mid] > array[mid + 1])
				return mid;
			else if(array[mid] > array[mid -1] && array[mid] < array[mid + 1])
				startIndex = mid + 1;
			else
				endIndex = mid - 1;
		}
		return -1;
	}
}