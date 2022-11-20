//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;
class HanoiTowerIterative{
    int nDisk, poleS, poleT, poleD;
    List<Integer> listPoleS = new ArrayList<Integer>();
    List<Integer> listPoleT = new ArrayList<Integer>();
    List<Integer> listPoleD = new ArrayList<Integer>();
    //default constructor
    public HanoiTowerIterative(){
        nDisk = 0;
        poleS = 1;
        poleT = 2;
        poleD = 3;
        for(int i = 1; i <= nDisk; i++){
            listPoleS.add(i);
            listPoleT.add(i);
            listPoleD.add(i);
        }
    }
    //parametric constructor
    public HanoiTowerIterative(int nTmp){
        this();
        this.nDisk = nTmp;
        for(int i = 1; i <= nDisk; i++){
            listPoleS.add(i);
        }
    }
    //method to decide direction and object, print out move detail
    public static void direction(List<Integer> listPoleS, List<Integer> listPoleD, int poleS, int poleD){
        //when one pole is empty, the other one is not
        if(listPoleS.size() != 0 && listPoleD.size() == 0){
            System.out.println("Move disk " + listPoleS.get(0) + " from Pole " + poleS + " to Pole " + poleD);
            listPoleD.add(listPoleS.get(0));
            listPoleS.remove(0);
        }else if(listPoleS.size() == 0 && listPoleD.size() != 0){
            System.out.println("Move disk " + listPoleD.get(0) + " from Pole " + poleD + " to Pole " + poleS);
            listPoleS.add(listPoleD.get(0));
            listPoleD.remove(0);
        }else if(listPoleS.get(0) < listPoleD.get(0)){//when two poles are not empty, compare the top disk
            System.out.println("Move disk " + listPoleS.get(0) + " from Pole " + poleS + " to Pole " + poleD);
            listPoleD.add(0, listPoleS.get(0));
            listPoleS.remove(0);
        }else if(listPoleS.get(0) > listPoleD.get(0)){
            System.out.println("Move disk " + listPoleD.get(0) + " from Pole " + poleD + " to Pole " + poleS);
            listPoleS.add(0, listPoleD.get(0));
            listPoleD.remove(0);
        }
    }
    //method to print every move, start from first move to the last move
    public static void loop(int nDisk, List<Integer> listPoleS, List<Integer> listPoleT, List<Integer> listPoleD, int poleS, int poleT, int poleD){
        //if the nDisk is even, interchange the poleT and poleD
        if(nDisk % 2 == 0){
            int poleTmp = poleT;
            poleT = poleD;
            poleD = poleTmp;
        }
        //get moves
        int moves = (int)Math.pow(2, nDisk) - 1;
        System.out.println("Total " + moves + " move(s): ");
        //print every move by calling method direction
        for(int i = 1; i <= moves; i++){
            if(i % 3 == 1)
                direction(listPoleS, listPoleD, poleS, poleD);
                //System.out.println(listPoleS);
            else if(i % 3 == 2)
                direction(listPoleS, listPoleT, poleS, poleT);
                //System.out.println(listPoleS);
            else if(i % 3 == 0)
                direction(listPoleT, listPoleD, poleT, poleD);
                //System.out.println(listPoleS);
        }
    }
}
