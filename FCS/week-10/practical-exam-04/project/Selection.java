/*
*   Foundations of Computer Science
*   2022, Semester 01
*   Practical-Exam-04
*
*   student (id): a1865304
*   student (name): Qingyan Yang
*
* Note: in order to finish your exam you need to make changes in this class
* Problem 03
*/
public class Selection extends Sort{

	@Override
	public int [] sortIntByIndex(int [] arr){
		int [] index = this.getIndex(arr.length);
		//int len = arr.length;
		int[] arrNew = arr.clone();
		for(int i = 0; i < arr.length - 1; i++){
			int minIndex = i;
			int keyIndex = index[i];
			for(int j = i; j < arr.length - 1; j++){
				if(arrNew[minIndex] > arrNew[j + 1]){
					minIndex = j + 1;
					keyIndex = j + 1;
				}
			}
			int tmp = arrNew[minIndex];
			arrNew[minIndex] = arrNew[i];
			arrNew[i] = tmp;

			int tmp1 = index[keyIndex];
			index[keyIndex] = index[i];
			index[i] = tmp1;
		}
		return index;
	}

	@Override
	public int [] sortInt(int [] arr){
		throw new java.lang.UnsupportedOperationException("Not implemented yet!");
	}


	@Override
	public int [] sortStringByIndex(String [] arr){
		throw new java.lang.UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public String [] sortString(String [] arr){
		int len = arr.length;
		String[] arrNew = arr.clone();
		for(int i = 0; i < len - 1; i++){
			int maxIndex = i;
			for(int j = i; j < len - 1; j++){
				if(arrNew[maxIndex].compareTo(arrNew[j + 1])>0){
					maxIndex = j + 1;
				}
			}
			String tmp = arrNew[maxIndex];
			arrNew[maxIndex] = arrNew[i];
			arrNew[i] = tmp;
		}
		return arrNew;
	}
}
