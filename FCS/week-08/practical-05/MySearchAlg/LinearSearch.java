import java.util.*;
import java.io.*;
class LinearSearch extends MySearchAlg{
	//default constructor
	public LinearSearch(){
		super();
	}
	//linear search algorithm
	public int search(int[] array, int num){
		this.n = array.length;
		for(int i = 0; i < n; i++){
			if(array[i] == num)
				return i;
		}
		return -1;
	}
	//linear search algorithm to find all same elements
	public Stack<Integer> search1(int[] array, int num){
		Stack<Integer>  stack1 = new Stack<Integer>();
		this.n = array.length;
		for(int i = 0; i < n; i++){
			if(array[i] == num)
				stack1.push(i);
		}
		return stack1;
	}
}