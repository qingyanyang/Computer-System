public class Node {
    int val;
    Node next;

    public Node() {
        val = 0;
        next = null;
    }

    public Node(int val) {
        this();
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public void printNode(){
        System.out.println(this.val);
    }
}
