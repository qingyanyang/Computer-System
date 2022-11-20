class Student extends Person{
    double [] marks = {0.0d, 0.0d, 0.0d};
    String [] disciplines = {"FCS", "FPM", "CCT"};
    String type;
    //create a constractor with parameters
    public Student(){
        super(20);
        type = getType();
    }
    //constructor with parameters
    public Student(double mark1, double mark2, double mark3){
        super(25);
        marks[0] = mark1;
        marks[1] = mark2;
        marks[2] = mark3;
    }
    //mutator
    public String getType(){
        return this.type;
    }
    //accessor
    public void setType(String type){
        this.type = type;
    }
    //create mothod to caculate average marks
    public double averageMarks(){
        double sum = 0.0d;
        int i;
        for(i = 0; i < marks.length; i++)
            sum += marks[i];
        double average = sum / (i + 1);
        return average;
    }
    //create method to display marks[] one by oone
    public void displayDisciplines(){
        System.out.print("disciplines with marks: ");
        for(int j = 0; j < disciplines.length; j++)
            System.out.print(disciplines[j] + ": " + marks[j] + " ");
        System.out.println("");
    }
}