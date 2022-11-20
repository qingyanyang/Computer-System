import java.util.ArrayList;
public class ServiceCenter {
    private WaitingList awl;
    private ArrayList<Integer> ambulanceList;

    public ServiceCenter() {
        this.awl = new WaitingList();
        this.ambulanceList = new ArrayList<Integer>();
    }

    /**
     * Record patient's data and add the patient into waiting list
     * @param name
     * @param phoneNumber
     * @param triageLevel
     * @param location
     */
    public void addPatientIntoList(String name, String phoneNumber, int triageLevel, String location) {
        Patient patient = new Patient(name, phoneNumber, triageLevel, location);
        if(this.awl.isInList(patient)){
            System.out.println(patient.getName() + " is in waiting list. ");
        }else{
            this.awl.addToList(patient);
            System.out.println("Add " + patient.getName() + " into waiting list. ");
        }
    }
    //method to add ambulance by no.
    public ArrayList<Integer> addAmbulance(int i){
        this.ambulanceList.add(i);
        System.out.println("Success! Ambulance no." + i + " has been added in the list.");
        return this.ambulanceList;
    }
    //method to delete first ambulance and get it
    public int popAmbulance(ArrayList<Integer> ambulanceList){
        int i = 0;
        if(ambulanceList.size() != 0){
            i = ambulanceList.get(0);
            ambulanceList.remove(0);
        }
        return i;
    }
    //remove patient method
    public Patient removePatientById(int id){
        if(this.awl.head == null){
            System.out.println("Error! The waiting list is empty.");
            return null;
        }else{
            Node tmp = this.awl.head;
            Node pre = null;
            while(tmp != null && id != tmp.patient.getId()){
                pre = tmp;
                tmp = tmp.next;
            }
            if(tmp == null){
                System.out.println("The id is not in the list!");
                return null;
            }else{
                if(pre == null){
                    this.awl.head = tmp.next;
                }else{
                    pre.next = tmp.next;
                }
                System.out.println("Success! patient " + id + " " + tmp.patient.getName() + " has been removed from the waitinglist!");
            }
            return tmp.patient;
        }
    }
    /**
     * Pop out the first patient in the waiting list and assign an Ambulance for him/her
     * @return the patient object
     */
    public Patient assignAmbulanceForPatient() {
        if(this.awl.head == null){
            System.out.println("Error! The waiting list is empty.");
            return null;
        }else{
            if(this.ambulanceList.size() != 0){
                Patient patient = this.awl.popPatient();
                System.out.println("Assigned ambulance " + this.popAmbulance(this.ambulanceList) + " for patient: " + patient.getName());
                return patient;
            }else{
                System.out.println("Error! No ambulances on site!");
                return null;
            }
        }
    }
    //assign Ambulance by id method
    public Patient assignAmbulanceById(int id) {
        if(this.awl.head == null){
            System.out.println("Error! The waiting list is empty.");
            return null;
        }else{
            if(this.ambulanceList.size() == 0){
                System.out.println("Error! No ambulances on site!");
                return null;
            }else{
                Node tmp = this.awl.head;
                Node pre = null;
                while(tmp != null && id != tmp.patient.getId()){
                    pre = tmp;
                    tmp = tmp.next;
                }
                if(tmp == null){
                    System.out.println("The id is not in the list!");
                    return null;
                }else{
                    if(pre == null){
                        this.awl.head = tmp.next;
                    }else{
                        pre.next = tmp.next;
                    }
                    System.out.println("Success! Ambulance " + this.popAmbulance(this.ambulanceList) + " as assigned for patient " + id + " " + tmp.patient.getName());
                }
                return tmp.patient;
            }
        }
    }
    //check hhw many patients in front of the identified id
    public Patient CheckPositionById(int id) {
        if(this.awl.head == null){
            System.out.println("Error! The waiting list is empty.");
            return null;
        }else{
            Node tmp = this.awl.head;
            int count = 0;
            while(tmp != null && id != tmp.patient.getId()){
                tmp = tmp.next;
                count++;
            }
            if(tmp == null){
                System.out.println("The id is not in the list!");
                return null;
            }else{
                System.out.println("There are " + count + " patients before patient " + id + " " + tmp.patient.getName());
            }
            return tmp.patient;
        }
    }

    /**
     * Print out the waiting list
     */
    public void printWaitingList(){
        this.awl.printList();
    }
    //method to print ambulance list
    public void printAmbulanceList(){
        int i = 0;
        if(this.ambulanceList.size() != 0){
            System.out.print("Existing Ambulances(NO.): ");
            while(i < this.ambulanceList.size()){
                System.out.print(this.ambulanceList.get(i) + " ");
                i++;
            }
            System.out.println("");
        }else{
            System.out.println("No ambulances on site!");
        }

    }
}
