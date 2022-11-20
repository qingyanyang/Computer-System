import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Please choose the type of bike" + "\n");
        System.out.println("a) electric bike" + "\n" + "b) mountatin bike" + "\n" + "c) road bike"
         + "\n" + "d) hibrid" + "\n");
        String typeText = input.next();
        //call class electric bike and its superclass's methods,attributes
        if(typeText.equals("a")){
            ElectricBike electricBike1 = new ElectricBike();
            electricBike1.setColor("yellow");
            electricBike1.setYear(2019);
            electricBike1.setNumberGears(0);
            electricBike1.display1();
            electricBike1.setIs_serviced(true);
            electricBike1.setInDate("30/03/2022");
            electricBike1.setOutDate("31/03/2022");
            electricBike1.setServiceResponsible("nice service");
            electricBike1.checkoutService();
            electricBike1.battery = "out of power";
            electricBike1.display4();
            electricBike1.chargeBike();
            electricBike1.checkBreak(15.0d);

        }else if(typeText.equals("b")){//call class MountainBike and its superclass's methods,attributes
            MountainBike mountainBike1 = new MountainBike();
            mountainBike1.setColor("black");
            mountainBike1.setYear(2020);
            mountainBike1.setNumberGears(12);
            mountainBike1.display1();
            mountainBike1.setIs_serviced(true);
            mountainBike1.setInDate("22/03/2022");
            mountainBike1.setOutDate("23/03/2022");
            mountainBike1.setServiceResponsible("pretty good service");
            mountainBike1.checkoutService();
            mountainBike1.suspension = "works well";
            mountainBike1.forks = "works well";
            mountainBike1.display2();
            mountainBike1.changeGear(60.4d);
            mountainBike1.checkBreak("no any concerns");

        }else if(typeText.equals("c")){//call class RoadBike and its superclass's methods,attributes
            RoadBike roadBike1 = new RoadBike();
            roadBike1.setColor("red");
            roadBike1.setYear(2022);
            roadBike1.setNumberGears(18);
            roadBike1.display1();
            roadBike1.setIs_serviced(true);
            roadBike1.setInDate("11/03/2022");
            roadBike1.setOutDate("13/03/2022");
            roadBike1.setServiceResponsible("bad attitude");
            roadBike1.checkoutService();
            roadBike1.tyres = "works well";
            roadBike1.display3();
            roadBike1.changeGear("no any concerns");
            roadBike1.checkBreak("no any concerns");

        }else if(typeText.equals("d")){//call class Hibrid and its superclass's methods,attributes
            Hibrid hibrid1 = new Hibrid();
            hibrid1.setColor("white");
            hibrid1.setYear(2022);
            hibrid1.setNumberGears(14);
            hibrid1.display1();
            hibrid1.setIs_serviced(true);
            hibrid1.setInDate("15/03/2022");
            hibrid1.setOutDate("17/03/2022");
            hibrid1.setServiceResponsible("just so so");
            hibrid1.checkoutService();
            hibrid1.suspension = "ineffective, but no related repair service in our store";
            hibrid1.display4();
            hibrid1.changeGear(67.5d);
            hibrid1.checkBreak(15.0d);
        }else{
            System.out.println("invalid input!");//extral condition
        }

    }
}