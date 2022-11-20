/*
*   Foundations of Computer Science
*   2022, Semester 01
*   Practical-Exam-04
*
*   student (id): a1865304
*   student (name): Qingyan Yang
*
* Note: in order to finish your exam you need to make changes in this class
* Note: your are also required to perform small changes, as accessors and mutators;

*
*/
public class Insertion extends Sort{

	@Override
	public int [] sortIntByIndex(int [] arr){
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j] > key){
				if(arr[j] > key){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return index;
	}

	@Override
	public int [] sortInt(int [] arr){
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			int key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j] > key){
				if(arr[j] > key){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return arr;
	}

	@Override
	public int [] sortStringByIndex(String [] arr){
		//throw new java.lang.UnsupportedOperationException("Not implemented yet!");
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			String key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j].compareTo(key) > 0){
				if(arr[j].compareTo(key)>0){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return index;
	}

	@Override
	public String [] sortString(String [] arr){
		int [] index = this.getIndex(arr.length);

		for(int i = 1; i < arr.length; i++){
			String key = arr[i];
			int keyIndex = index[i];
			int j = i - 1;
			while( j >= 0 && arr[j].compareTo(key) >0){
				if(arr[j].compareTo(key) >0){
					arr[j+1] = arr[j];
					index[j+1] = index[j];
					j--;
				}
			}
			arr[j+1] = key;
			index[j+1] = keyIndex;
		}
		return arr;
	}


}