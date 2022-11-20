import java.util.Scanner;

class Problem08{
  public static void main(String[] args){

  Scanner input = new Scanner(System.in).useDelimiter("\n");
  // Getting name input
  System.out.print("Enter your name: ");
  String name = input.next();
  // Getting age input
  System.out.print("Enter your age: ");
  int age = input.nextInt();
  // Getting favorite food input
  System.out.print("Enter your favorite food: ");
  String favoriteFood = input.next();
  // Getting grade input
  System.out.print("Enter your maths grade: ");
  String mathsGrade = input.next();
  System.out.print("Enter your English grade: ");
  String englishGrade = input.next();
  // Getting height input
  System.out.print("Enter your height(cm): ");
  float height = input.nextFloat();
  // Getting weight input
  System.out.print("Enter your weight(kg): ");
  float weight = input.nextFloat();
  // Getting numbers of subjects input
  System.out.print("Enter numbers of your subjects: ");
  int number = input.nextInt();
    // Getting summary confirmation input
  System.out.println("you entered:" + "\n" + "name: " + name + "\n" + "age: " + age + "\n" + "favorite food: " + favoriteFood + "\n" + "maths grade: " + mathsGrade + "\n" + "English grade: " + englishGrade + "\n" + "height(cm): " + height + "\n" + "weight(kg): " + weight + "\n" + "number of subjects: " + number + "\n" + "please confirm the information above: yes or no? (y/n): ");
  char answer = input.next().charAt(0);
  }
}
