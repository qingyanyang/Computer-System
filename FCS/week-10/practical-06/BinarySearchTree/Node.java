public class Node{
	private int data;
	private Node left;
	private Node right;

	public Node(int data){
		left = null;
		right = null;
		this.data = data;
	}
	//accessors
	public int getData(){
		return this.data;
	}
	public Node getRight(){
		return this.right;
	}
	public Node getLeft(){
		return this.left;
	}
	//mutators
	public void setData(int data){
		this.data = data;
	}
	public void setRight(Node right){
		this.right = right;
	}
	public void setLeft(Node left){
		this.left = left;
	}
	//method to display
	public void printNode(){
		System.out.print(this.data);
	}
}