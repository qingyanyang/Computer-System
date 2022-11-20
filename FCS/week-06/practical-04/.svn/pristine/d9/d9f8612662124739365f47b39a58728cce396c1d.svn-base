//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
import java.util.*;
public class ShakingPartyConstrainted{
    private int nCouples;
    //defualt constructor
    public ShakingPartyConstrainted(){
       Random ran = new Random();
       nCouples = ran.nextInt(1000);
    }
    //constructor with parameter
    public ShakingPartyConstrainted(int nTmp){
        this();
        this.nCouples = nTmp;
    }
    //Accessors to get value of nCouples
    public int getNCouples(){
        return this.nCouples;
    }
    //Mutators to set value of nCouples
    public void setNCouples(int nCouples){
        this.nCouples = nCouples;
    }
    //method to calculate number of shake-hands
    public int countHandShakes(int nCouples){
        if(nCouples == 1){
            int handShakeTimes = 0;
            return handShakeTimes;
        }else{
            int handShakeTimes = (nCouples - 1) * 2 + countHandShakes(nCouples - 1);
            return handShakeTimes;
        }
    }
}