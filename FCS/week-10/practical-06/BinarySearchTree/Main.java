import java.lang.Math;
public class Main{
	int count = 0;
	//binary search method
	public int binarySearch(int[] arr, int value){
		int start = 0;
		int end = arr.length - 1;
		while(start <= end){
			int mid = Math.round((start + end) / 2.0f);
			if(arr[mid] == value){
				this.count++;
				System.out.println("Search integer " + value + ", Is it in the tree? true");
				System.out.println("Totally compared " + count + " times.");
				return mid;
			}else if(value > arr[mid]){
				this.count++;
				start = mid + 1;
			}else{
				this.count++;
				end = mid - 1;
			}
		}
		System.out.println("Search integer " + value + ", Is it in the tree? false");
		System.out.println("Totally compared " + count + " times.");
		return -1;
	}

	public static void main(String[] args){
		int[] arr = {0,1,2,3,4,5,6,7,8,9,11,12};
		Main binarySearch1 = new Main();
		double startTime3 = System.nanoTime() * Math.pow(10,-9);   //get start time
		int index = binarySearch1.binarySearch(arr, 2);
		double endTime3 = System.nanoTime() * Math.pow(10,-9); //get end time
		System.out.printf("totally spent：%.5f s %n",(endTime3 - startTime3));
		double startTime4 = System.nanoTime() * Math.pow(10,-9);   //get start time
		int index2 = binarySearch1.binarySearch(arr, 13);
		double endTime4 = System.nanoTime() * Math.pow(10,-9); //get end time
		System.out.printf("totally spent：%.5f s %n",(endTime4 - startTime4));
		MyBST binarySeachTree = new MyBST();
		//insert value
		binarySeachTree.insert(6);
		binarySeachTree.insert(3);
		binarySeachTree.insert(8);
		binarySeachTree.insert(2);
		binarySeachTree.insert(4);
		binarySeachTree.insert(7);
		binarySeachTree.insert(9);
		binarySeachTree.insert(0);
		binarySeachTree.insert(1);
		binarySeachTree.insert(5);
		binarySeachTree.insert(11);
		binarySeachTree.insert(12);
		binarySeachTree.insert(7);
		//display tree
		System.out.println("display tree:");
		System.out.println("           [6]               ");
		System.out.println("          /   \\             ");
		System.out.println("        /       \\           ");
		System.out.println("      [3]       [8]          ");
		System.out.println("     /  \\       /  \\       ");
		System.out.println("   [2]  [4]   [7]   [9]      ");
		System.out.println("   /      \\           \\    ");
		System.out.println(" [0]      [5]         [11]   ");
		System.out.println("   \\                    \\  ");
		System.out.println("   [1]                  [12] ");
		System.out.println("preOrder display:");
		//display preorderly
		binarySeachTree.preOrderDisplay();
		int i = 2, j = 13;

		double startTime = System.nanoTime() * Math.pow(10,-9);   //get start time
		//search
		boolean a = binarySeachTree.search(i);
		System.out.println("Search integer " + i + ", Is it in the tree? " + a);
		binarySeachTree.searchStep(i);
		double endTime = System.nanoTime() * Math.pow(10,-9); //get end time
		System.out.printf("totally spent：%.5f s %n",(endTime - startTime));

		double startTime2 = System.nanoTime() * Math.pow(10,-9);   //get start time
		//search
		boolean b = binarySeachTree.search(j);
		System.out.println("Search integer " + j + ", Is it in the tree? " + b);
		binarySeachTree.searchStep(j);
		double endTime2 = System.nanoTime() * Math.pow(10,-9); //get end time
		System.out.printf("totally spent：%.5f s %n",(endTime2 - startTime2));
	}
}