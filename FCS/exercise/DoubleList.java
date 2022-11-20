public class DoubleList {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
            left = right = null;
        }
        public void display(){
            System.out.println(this.value);
        }
    }
    Node head;
    Node tail;
    public Node add(Node node){
        if(head == null){
            this.head = node;
            this.tail = node;
            return this.head;
        }else{
            this.head.left = node;
            node.right = this.head;
            this.head = node;
            return this.head;
        }
    }
    public void displayList(){
        Node tmp = this.tail;
        while(tmp != null){
            tmp.display();
            tmp = tmp.left;
        }
    }

    public static void main(String[] args) {
        DoubleList list = new DoubleList();
        Node newNode = new Node(1);
        Node newNode2 = new Node(2);
        list.add(newNode);
        list.add(newNode2);
        list.displayList();
        list.head = null;
        list.displayList();
    }
}
