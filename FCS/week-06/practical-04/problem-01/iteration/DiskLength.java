//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
import java.util.Scanner;
class DiskLength{
    float f;
    //default constructor
    public DiskLength(){
        f = 0;
    }
    //method to get input of users and screen positive integer
    public int inputLength(){
        int inputNumber;
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Enter the number of disks: ");
        //screen positive integer
        while(true){
            try{
                inputNumber = input.nextInt();//screen integer
                boolean judge = inputNumber > 0;//screen positive number
                if(!judge)
                    f = 1 / 0;
                break;
            }catch(Exception e){
                //loop if input is not meet requiement
                System.out.print("invalid number! Try again:");
                input = new Scanner(System.in).useDelimiter("\n");
            }
        }
        return inputNumber;
    }
}