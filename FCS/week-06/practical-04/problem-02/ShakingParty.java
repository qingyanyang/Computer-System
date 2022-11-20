//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
import java.util.*;
public class ShakingParty{
    private int nPeople;
    //defualt constructor
    ShakingParty(){
        Random ran = new Random();
        nPeople = ran.nextInt(1000);
    }
    //constructor with parameter
    ShakingParty(int nTmp){
        this();
        this.nPeople = nTmp;
    }
    //Accessors to get value of nPeople
    public int getNPeople(){
        return this.nPeople;
    }
    //Mutators to set value of nPeople
    public void setNPeople(int nPeople){
        this.nPeople = nPeople;
    }
    //method to calculate number of shakinghands
    public int countHandShakes(int nPeople){
        if(nPeople == 1){
            int handShakeTimes = 0;
            return handShakeTimes;
        }else{
            int handShakeTimes = (nPeople - 1) + countHandShakes(nPeople - 1);
            return handShakeTimes;
        }
    }
}