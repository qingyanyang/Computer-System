public class NodeList {
    Node head;

    public NodeList() {
        head = null;
    }
    public void addNode(int value){
        if(this.head == null){
            this.head = new Node(value);
        }else{
            Node tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node(value);
        }
    }
    public void printList(){
        Node tmp = this.head;
        while(tmp != null){
            tmp.printNode();
            tmp = tmp.next;
        }
    }
}
