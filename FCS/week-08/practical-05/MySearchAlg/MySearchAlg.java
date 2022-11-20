import java.util.*;
import java.io.*;
public abstract class MySearchAlg{
	int n;
	//default construtor
	public MySearchAlg(){
		n = 0;
	}
	abstract int search(int[] array, int num);
	//display method
	public void display(int [] array, int num, int index){
		System.out.print("[");
		for(int i : array)
			System.out.print(i + " ");
		System.out.println("]");
		if(index == -1)
			System.out.println("Number " + num + " is not existing in this array.");
		else
			System.out.println("Number " + num + " is located at index " + index + " of this array.");
	}
	//display method
	public void display1(int [] array, int num, Stack<Integer> stack1){
		System.out.print("[");
		for(int i : array)
			System.out.print(i + " ");
		System.out.println("]");
		if(stack1.isEmpty()){
			System.out.println("Number " + num + " is not existing in this array.");
		}else{
			while(!stack1.isEmpty()){
				System.out.println("Number " + num + " is located at index " + stack1.pop() + " of this array.");
			}
		}
	}
}