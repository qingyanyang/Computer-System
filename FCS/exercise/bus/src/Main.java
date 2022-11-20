import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    static int inputAnswer;
    static LinkedList<Bus> buses = new LinkedList<Bus>();

    public static void addABus(int i){
        Bus bus1 = new Bus(i);
        buses.add(bus1);
    }
    public static void reservation(int busId, int seatId, String name){
        buses.get(busId).makeReservation(busId, seatId, name);
    }
    public static void showBusesInfo(int busId){
        buses.get(busId).printInfo();
    }
    public static boolean userInputIsValid(Scanner input){
            try{
                inputAnswer = input.nextInt();
                if(inputAnswer < 1 || inputAnswer > 4){
                    float f = 1/0;
                }
                return true;
            }catch (Exception e){
                return false;
            }
    }

    public static void main(String[] args) {
        //int inputAnswer;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to bus reservation system");
        System.out.println("1. Add a bus");
        System.out.println("2. Reservation");
        System.out.println("3. Show buses information");
        System.out.println("4. Exit");
        System.out.println("Enter your choice (a number):");
        while(!userInputIsValid(input)){
            System.out.println("Invalid number! Please try again: ");
            input = new Scanner(System.in);
        }
        switch (inputAnswer){
            case 1:
                System.out.println("enter busId:");
                int id = input.nextInt();
                addABus(id);
                break;
            case 2:
                System.out.println("enter busId, seatId and name:");
                int busId = input.nextInt();
                int seatId = input.nextInt();
                String name = input.next();
                reservation(busId, seatId, name);
                break;
            case 3:
                System.out.println("enter busId:");
                int busid = input.nextInt();
                showBusesInfo(busid);
                break;
           default:
                System.out.println("");
        }
    }
}
