public class WaitingList {
    protected Node head;
    protected int numNodes;

    public WaitingList(){
        this.head = null;
        this.numNodes = 0;
    }

    /**
     * This method will pop the first patient from the waiting list
     * @return the patient popped from the waiting list
     */
    public Patient popPatient() {
        if(this.head != null){
            Node tmp = this.head;
            this.head = this.head.next;
            this.numNodes--;
            return tmp.patient;
        }
        return null;
    }

    /**
     * This method will add patient into the waiting list according to the triage level
     * @param patient patient's data
     */
    public void addToList(Patient patient) {
        Node newNode = new Node(patient);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node tmp = this.head;
            Node pre = null;
            while(tmp != null && newNode.patient.getTriageLevel() <= tmp.patient.getTriageLevel()){
                pre = tmp;
                tmp = tmp.next;
            }
            if(pre == null){
                newNode.next = this.head;
                this.head = newNode;
            }else{
                pre.next = newNode;
                newNode.next = tmp;
            }
        }
    }

    /**
     * print out the information for each patient in waiting list
     */
    public void printList() {
        Node tmp = this.head;
        if(tmp != null){
            System.out.println("Patient info: Id" + "     Name" + "   TriageLevel");
        }
        while(tmp != null){
            tmp.printNode();
            tmp = tmp.next;
        }
        System.out.println("Total: " + this.size() + " patient(s) in the waiting list.");
    }

    /**
     * Check whether the patient is in this list or not
     * @return
     */
    public boolean isInList(Patient patient) {
        if (this.head == null) {
            return false;
        }
        Node temp = this.head;
        while(temp != null) {
            if(temp.getPatient().getName().equals(patient.getName())
                    && temp.getPatient().getPhoneNumber().equals(patient.getPhoneNumber())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    //method to get numbers of nodes
    public int size(){
        Node tmp = this.head;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
}
