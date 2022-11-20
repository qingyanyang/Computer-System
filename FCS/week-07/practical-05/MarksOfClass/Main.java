import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        try{
            Student s = new Student();
            //call sortStudents method
            Student[] studentsSorted = s.sortStudents(readData("students.txt"));
            printStudents(studentsSorted);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    //method to read textfile into 2D matrix and attribute to student array
    private static Student[] readData(String filename) throws IOException{
        ArrayList<String> listOfStrings = new ArrayList<String>();
        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader(filename));
        // read entire line as string
        String line = bf.readLine();
        int column = 0;
        //reading column with content only
        while (line != null) {
            //listOfStrings.add(line);
            listOfStrings.add(line);
            //count columns
            column++;
            line = bf.readLine();
        }
        // closing bufferreader object
        bf.close();
        //create 2D array to hold arraylist listOfString's components
        String [][] matrix = new String[column][];
        for(int i = 0; i < column; i++){
            String s = listOfStrings.get(i);
            String[] vals = s.split(" ");
            int row = vals.length;
            //every new column have be defined
            matrix[i] = new String[row];
            for(int j = 0; j < row; j++){
                matrix[i][j] = vals[j];
            }
        }
        //put all elements into students array of class Student
        Student [] students= new Student[column];
        for(int k = 0; k < column; k++){
            students[k] = new Student(matrix[k][0], Integer.parseInt(matrix[k][1]), Integer.parseInt(matrix[k][2]), Integer.parseInt(matrix[k][3]));
        }
        return students;
    }
    //method to print out students[] in descending order
    public static void printStudents(Student[] students){
        System.out.println("Student " + "AverageScore " + "Physics " + "Chemistry " + "Math");
        for(int i = 0; i < students.length; i++){
            System.out.printf("%-8s%-13s%-8s%-10s%-5s", students[i].getName(), students[i].getAverage(), students[i].getPhysics(), students[i].getChemistry(), students[i].getMath());
            System.out.println("");
        }
    }
}