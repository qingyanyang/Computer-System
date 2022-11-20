public class Node{
    private int index;
    public Node(){
        index = 0;
    }
    public Node(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    // Print the data (the index) saved in the node.
    public void printNode(){
        System.out.print(this.index + " ");
    }
}