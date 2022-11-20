import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class GFG{
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(12,"Jack"));
        studentList.add(new Student(11,"Jimmy"));
        studentList.add(new Student(10,"Young"));
        studentList.add(new Student(12,"Sara"));
        studentList.add(new Student(13,"Amy"));
        System.out.println("unsorted");
        for(int i = 0; i < studentList.size(); i++){
            System.out.println(studentList.get(i).toString());
        }
        System.out.println("sorting by name");
        Comparator<Student> comparator = new Student.SortRule();
        Collections.sort(studentList, comparator);
        for(int j = 0; j < studentList.size(); j++){
            System.out.println(studentList.get(j).toString());
        }
    }
}