public class MyStack{
    private Node top;
    public MyStack(){
        top = null;
    }
    public Node getTop(){
        return this.top;
    }
    public void setFront(Node top){
        this.top = top;
    }
    // Push a node into stack
    public void push(Node node){
        node.setNext(this.top);
        this.top = node;
    }

    // Get and remove the top node from this stack.
    // Return Null and print "Stack is empty" when the stack is empty.
    public Node pop(){
        Node tmp = null;
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }else{
            tmp = this.top;
            this.top = this.top.getNext();
        }
        return tmp;
    }

    // Get the top node in this stack.
    // Return Null and print "Stack is empty" when the stack is empty.
    public Node peek(){
        if(this.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return this.top;
    }

    // Return TRUE when the stack is empty, otherwise, return FALSE.
    public boolean isEmpty(){
        if(this.top == null)
            return true;
        else
            return false;
    }
}