import java.util.Scanner;
class NumberScreen{
    int number3, number4;
    public void numberScreen(String numberText1, String numberText2){
        int number1 = 0, number2 = 0, number3 = 0, number4 = 0;
        //screen two integers
        if ((numberText1 != null && numberText1.matches("^[0-9]+$")) && (numberText2 != null && numberText2.matches("^[0-9]+$"))){
            //convert string to integer
            number1 = Integer.parseInt(numberText1);
            number2 = Integer.parseInt(numberText2);
            //screen integer ∈ [1,1000]
            if((number1 <= 10*10*10 && number1 >= 1) && (number2 <= 10*10*10 && number2 >= 1)){
                number3 = number1;
                number4 = number2;
            }else{
                System.out.println("cautions:number you input should ∈ [1,1000]");
            }
        }else{
            do{ //start loop if input is not int number
                Scanner input = new Scanner(System.in);
                System.out.print("invalid input!Enter again!" + "\n" + "Input:" + "\n");
                numberText1 = input.next(); numberText2 = input.next();
                // try again
                if ((numberText1 != null && numberText1.matches("^[0-9]+$")) && (numberText2 != null && numberText2.matches("^[0-9]+$"))){
                    number1 = Integer.parseInt(numberText1);
                    number2 = Integer.parseInt(numberText2);
                    //screen integer ∈ [1,1000]
                    if((number1 <= 10*10*10 && number1 >= 1) && (number2 <= 10*10*10 && number2 >= 1)){
                        number3 = number1;
                        number4 = number2;
                    }else{
                        System.out.println("cautions:number you input should ∈ [1,1000]");
                    }
                }
            }while(( !numberText1.matches("^[0-9]+$")) || ( !numberText2.matches("^[0-9]+$")));
        }
        this.number3 = number3;
        this.number4 = number4;
    }
}