class Lecturer extends Person{
    double salary;
    String [] disciplines = {"FCS", "FPM", "CCT"};
    String type;
    //create a constructor without parameters and call superclass constructor
    public Lecturer(){
        super(32);
        salary = 0.0d;
        type = "unknown";
    }
    //constructor with parameter
    public Lecturer(String type){
        super(32);
        this.type = type;
        System.out.println("type: " + this.type);
    }
    //create method to diaplay info
    public void displayDisciplines(int index){
        System.out.println("discipline: " + disciplines[index]);
    }
    //create method to calculate annual salary
    public double annualSalary(){
        double yearSalary = 12 * (this.salary);
        return yearSalary;
    }
    //Mutator to set salary value
    public void setSalary(double salary){
        this.salary = salary;
    }
    //Accessor to get salary value
    public double getSalary(){
        return this.salary;
    }
}