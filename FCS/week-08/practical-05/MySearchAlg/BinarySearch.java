import java.util.*;
import java.io.*;
import java.lang.Math;
class BinarySearch extends MySearchAlg{
	//default constructor
	public BinarySearch(){
		super();
	}
	//binary search algorithm
	public int search(int [] array, int num){
		this.n = array.length - 1;
		int startIndex = 0;
		int endIndex = n;
		while(startIndex <= endIndex){
			int mid = startIndex + Math.round((endIndex - startIndex) / 2.0f);
			if(num == array[mid]){
				return mid;
			}else if(num > array[mid]){
				startIndex = mid + 1;
			}else{
				endIndex = mid - 1;
			}
		}
		return -1;
	}
	//binary search algorithm can find all same elements
	public Stack<Integer> search1(int [] array, int num){
		this.n = array.length - 1;
		Stack<Integer> stack2 = new Stack<Integer>();
		int startIndex = 0;
		int endIndex = n;

		while(startIndex <= endIndex){
			int mid = startIndex + Math.round((endIndex - startIndex) / 2.0f);
			if(num == array[mid]){
				int count = 1;
				int i = 1;
				//getting other same number in front or behind mid
				while((mid - i) >= 0 && array[mid - i] == num){
					count++;
					i++;
				}
				int firstIndex = mid - i + 1;
				int j = 1;
				while((mid + j) < array.length && array[mid + j] == num){
					count++;
					j++;
				}
				//put them into stack
				for(int times = 0; times < count; times++)
					stack2.push(firstIndex + times);
				return stack2;
			}else if(num > array[mid]){
				startIndex = mid + 1;
			}else{
				endIndex = mid - 1;
			}
		}
		return stack2;
	}

	//binary search algorithm
	public int search2(int [] array, int num, int startIndex, int endIndex){
		int n = endIndex - startIndex;
		int mid = startIndex + Math.round(n / 2.0f);
		if(startIndex > endIndex)
			return -1;
		if(num == array[mid] )
			return mid;
		else if(num > array[mid])
			return search2(array, num, mid + 1, endIndex);
		else
			return search2(array, num, startIndex, mid - 1);
	}
}