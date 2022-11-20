//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
import java.lang.Math;
class HanoiTower{
    int nDisk, poleS, poleT, poleD;
    //defualt constructor
    HanoiTower(){
        nDisk = 0;
        poleS = 1;
        poleT = 2;
        poleD = 3;
    }
    //constructor with parameter
    HanoiTower(int dTmp){
        this();
        this.nDisk = dTmp;
    }
    //display number of moves
    public void display(int nDisk){
        int moves = (int)Math.pow(2, nDisk) - 1;
        if(nDisk == 1)
            System.out.println("Total " + moves + " move, it is:");
        else
            System.out.println("Total " + moves + " moves, they are:");
    }
    //recursion method to print step of move
    public void solve(int nDisk, int poleS, int poleT, int poleD){
        // minimum value of parameter nDisk
        if(nDisk == 0){
            System.out.print("");
        }else{
            //move the disks stock upon the bottom disk from poleS to poleT
            solve((nDisk - 1), poleS, poleD, poleT);
            //move the bottom disk from poleS to poleD
            System.out.println("Move disk " + nDisk + " from Pole " + poleS + " to Pole " + poleD);
            //relocate the disks stock upon the bottom disk from poleT to poleD
            solve((nDisk - 1), poleT, poleS, poleD);
        }
    }
}