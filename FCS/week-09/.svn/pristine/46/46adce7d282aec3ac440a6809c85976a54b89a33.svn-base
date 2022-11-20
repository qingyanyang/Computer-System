public class Node {
    protected Node next;
    protected Patient patient;

    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    //print node
    public void printNode() {
        System.out.printf("%15s%10s%10s", this.patient.getId(), this.patient.getName(), this.patient.getTriageLevel());
        System.out.println("");
    }
}
