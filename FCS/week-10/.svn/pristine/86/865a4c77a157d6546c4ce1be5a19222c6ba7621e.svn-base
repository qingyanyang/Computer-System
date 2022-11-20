import java.util.LinkedList;
public class MyGraph{
    LinkedList<Node>[] adjListArray;
    public MyGraph(){
        adjListArray = new LinkedList[0];
    }
    // transform an adjacency matrix to an adjacency list
    public void matrixToList(int[][] matrix){
        if(matrix.length != 0){
            int len = matrix.length;
            this.adjListArray = new LinkedList[len];
            //this.adjListArray = new LinkedList<Node>[len];
            for(int i = 0; i < len; i++ ){
                this.adjListArray[i] = new LinkedList<Node>();
                Node indexNode = new Node(i);
                this.adjListArray[i].add(indexNode);
                for(int j = 0; j < len; j++){
                    if(matrix[i][j] == 1){
                        Node adjNode = new Node(j);
                        this.adjListArray[i].add(adjNode);
                    }
                }
            }
        }
    }
    // Print out the adjacency list array
    public void displayAdjListArray(){
        for(int j = 0; j < this.adjListArray.length; j++){
            System.out.print(this.adjListArray[j].get(0).getIndex() + ":");
            int i = 1;
            while(i < this.adjListArray[j].size()){
                System.out.print(" Node ");
                this.adjListArray[j].get(i).printNode();
                i++;
                if(i < this.adjListArray[j].size())
                    System.out.print(" -> ");
            }
            System.out.println("");
        }
    }
}