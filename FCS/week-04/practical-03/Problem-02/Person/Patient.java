class Patient extends Person{
    String diagnostic, inTime, prevTime, type;
    //create a constructor without parameters and inhertate the atrributes of super class
    public Patient(){
        super(29);
        diagnostic = getDiagnostic();
        inTime = getInTime();
        prevTime = getPrevTime();
    }
    //constructor with parameters
    public Patient(String type){
        super(22);
        this.type = type;
        System.out.println("type: " + this.type);
    }
    //Accessor to get diagnostic value
    public String getDiagnostic(){
        return this.diagnostic;
    }
    //Accessor to get inTime value
    public String getInTime(){
        return this.inTime;
    }
    //Accessor to get prevTime value
    public String getPrevTime(){
        return this.prevTime;
    }
    //Mutator to set diagnostic value
    public void setDiagnostic(String diagnostic){
        this.diagnostic = diagnostic;
    }
    //Mutator to set inTime value
    public void setInTime(String inTime){
        this.inTime = inTime;
    }
    //Mutator to set prevTime value
    public void setPrevTime(String prevTime){
        this.prevTime = prevTime;
    }
}