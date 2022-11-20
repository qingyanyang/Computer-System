import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        //display graph
        System.out.println("display graph:");
        System.out.println("   [0]--[2]    ");
        System.out.println("   |   /  \\   ");
        System.out.println("   |  /   [3]  ");
        System.out.println("   [1]    /    ");
        System.out.println("     \\[4]     ");
        System.out.println("display matrix:");
        System.out.printf("%3d%2d%2d%2d%2d%n",0,1,2,3,4);
        int[][] matrix ={{0,1,1,0,0},{1,0,1,0,1},{1,1,0,1,0},{0,0,1,0,1},{0,1,0,1,0}};
        int len = matrix.length;
        for(int i = 0; i < len; i++){
            System.out.print(i + " ");
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        MyGraph graph = new MyGraph();
        graph.matrixToList(matrix);
        //display listArray
        System.out.println("display ListArray:");
        graph.displayAdjListArray();
    }
}