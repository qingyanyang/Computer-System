public class Student{
    String name;
    int physics;
    int chemistry;
    int math;
    int average;
    //default constructor
    public Student(){
        name = "Chelsea";
        physics = 98;
        chemistry = 87;
        math = 68;
        average = 0;
    }
    //parametric constructor
    public Student(String name, int physics, int chemistry, int math){
        this();
        this.name = name;
        this.physics = physics;
        this.chemistry = chemistry;
        this.math = math;
        this.average = Math.round((physics + chemistry + math) / 3.0f);
    }
    //accessors to get value
    public String getName(){
        return this.name;
    }
    public int getPhysics(){
        return this.physics;
    }
    public int getChemistry(){
        return this.chemistry;
    }
    public int getMath(){
        return this.math;
    }
    public int getAverage(){
        return this.average;
    }
    //mutators for set value
    public void setName(String name){
        this.name = name;
    }
    public void setPhysic(int physics){
        this.physics = physics;
    }
    public void setChemistry(int chemistry){
        this.chemistry = chemistry;
    }
    public void setMath(int math){
        this.math = math;
    }
    public void setAverage(int average){
        this.average = average;
    }
    //method to sort array in bubble algorithm
    public Student[] sortStudents(Student[] students){
        int n = students.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(students[j].average < students[j + 1].average){
                    Student tmp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tmp;
                }else if(students[j].average == students[j + 1].average){
                    if(students[j].physics < students[j + 1].physics){
                        Student tmp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = tmp;
                    }else if(students[j].physics == students[j + 1].physics){
                        if(students[j].chemistry < students[j + 1].chemistry){
                            Student tmp = students[j];
                            students[j] = students[j + 1];
                            students[j + 1] = tmp;
                        }else if(students[j].chemistry == students[j + 1].chemistry){
                            if(students[j].math < students[j + 1].math){
                                Student tmp = students[j];
                                students[j] = students[j + 1];
                                students[j + 1] = tmp;
                            }
                        }
                    }
                }
            }
        }
        return students;
    }
}