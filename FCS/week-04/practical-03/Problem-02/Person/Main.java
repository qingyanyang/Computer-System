class Main{
    public static void main(String[] args){
        //create new instance named doctor1 of Doctor class
        Doctor doctor1 = new Doctor("doctor", "dental");
        //call super class Mutator
        doctor1.setGivenName("Chelsea");
        doctor1.setLastName("Yang");
        //call super class method
        doctor1.display();
        System.out.println("speciality: " + doctor1.speciality);

        System.out.println("\n" + "------------" + "\n");

        //create new instance named lecturer1 of Lecturer class
        Lecturer lecturer1 = new Lecturer("Lecturer");
        //call super class Mutator
        lecturer1.setGivenName("Sam");
        lecturer1.setLastName("Smith");
        lecturer1.setGender("male");
        lecturer1.setCitizenship("America");
        //call super class method
        lecturer1.display();
        //call super class Mutator
        lecturer1.setSalary(4000.0d);
        lecturer1.displayDisciplines(0);
        System.out.println("salary: " + lecturer1.getSalary());//call super class Accessor
        System.out.println("annual salary:" + lecturer1.annualSalary());

        System.out.println("\n" + "------------" + "\n");

        //create new instance named student1 of Student class
        //and call constractor of this class with parameters
        Student student1 = new Student(78.3d, 88.5d, 90.5d);
        student1.setType("student");
        System.out.println("type: " + student1.getType());
        //call super class Mutator
        student1.setGivenName("Lina");
        student1.setLastName("Green");
        student1.setCitizenship("Australia");
        //call super class method
        student1.display();
        //call method in this class
        student1.displayDisciplines();
        System.out.println("average marks: " + student1.averageMarks());

        System.out.println("\n" + "------------" + "\n");

        //create new instance named lecturer1 of Lecturer class
        Patient patient1 = new Patient("Patient");
        //call super class Mutator
        patient1.setGivenName("Jeremy");
        patient1.setLastName("Jiang");
        patient1.setGender("male");
        //call super class method
        patient1.display();
        //call Mutator in this class
        patient1.setDiagnostic("headache");
        patient1.setInTime("Yes");
        patient1.setPrevTime("23/03/2022");
        //call Accessor in this class
        System.out.println("diagnostic: " + patient1.getDiagnostic());
        System.out.println("in time? " + patient1.getInTime());
        System.out.println("previous time: " + patient1.getPrevTime());
    }
}