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
class LinearSearch extends Search{    
    public int search(int arr[], int query){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == query)
                return i;
        }
        return -1;
    }

    public int search(String arr[], String query){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i].equals(query))
                return i;
        }
        return -1;
    }

    public int search(float arr[], float query){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == query)
                return i;
        }
        return -1;
    }
}