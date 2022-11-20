public class Person {
    String name;
    int age;
    public Person() {
        name = "anon";
        age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "Person: " + this.name + "is age: " + this.age + " ";
    }
}
