import java.util.Comparator;
public class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name + " " + this.age;
    }
    static class SortRule implements Comparator<Student>{

        @Override
        public int compare(Student student1, Student student2) {
            if(student1.age == student2.age){
                return student1.name.compareTo(student2.name);
            }else{
                return student1.age - student2.age;
            }
        }
    }

}
