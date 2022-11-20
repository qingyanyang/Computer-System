import java.util.Scanner;

public class Problem09{
  public static void main(String[] args){

  Scanner input = new Scanner(System.in).useDelimiter("\n");

  // Getting name input
  System.out.print("Enter dog's name: ");
  String name = input.next();

  // Getting age input
  System.out.print("Enter dog's age (eg:2 years 4 months): ");
  String age = input.next();

  // Getting favorite food input
  System.out.print("Enter dog's favorite food: ");
  String favoriteFood = input.next();

  // Getting height input
  System.out.print("Enter dog's height(cm): ");
  float height = input.nextFloat();

  // Getting weight input
  System.out.print("Enter dog's weight(kg): ");
  float weight = input.nextFloat();

  // Getting favorite toy
  System.out.print("Enter dog's favorite toy: ");
  String favoriteToy = input.next();

  // Getting owner's name input
  System.out.print("Enter owner's name:  ");
  String ownerName = input.next();

  // Getting summary confirmation input
  System.out.println("you entered:" + "\n" + "name: " + name + "\n" + "age: " + age + "\n" + "favorite food: " + favoriteFood + "\n" + "height(cm): " + height + "\n" + "weight(kg): " + weight + "\n" + "favorite toy: " + favoriteToy + "\n" + "owner's name: " + ownerName + "\n" + "please confirm the information above: yes or no? (y/n): ");
  char answer = input.next().charAt(0);
  }
}
