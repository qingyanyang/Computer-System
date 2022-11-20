//==================================
//Foundations of Computer Science
//Student: qingyan yang
//id: a1865304
//Semester: s01
//Year: 2022
//Practical Number: 04
//===================================
class Test{
    public static void main(String[]args){
        //create instance of class DiskLength to get nDisk of user's input
        DiskLength length1 = new DiskLength();
        //create instance of class HanoiTower and call its parametric constructor to set nDisk
        HanoiTower h1 = new HanoiTower(length1.inputLength());
        h1.display(h1.nDisk);
        //call solve method
        h1.solve(h1.nDisk, h1.poleS, h1.poleT, h1.poleD);
        //call Demo constructor to pop graphic window
        if(h1.nDisk == 1) {
            Demo d = new Demo("1move.gif");
        }
        if(h1.nDisk == 2) {
            Demo d = new Demo("3moves.gif");
        }
        if(h1.nDisk == 3) {
            Demo d = new Demo("7moves.gif");
        }
        if(h1.nDisk == 4) {
            Demo d = new Demo("15moves.gif");
        }
        if(h1.nDisk == 5) {
            Demo d = new Demo("31moves.gif");
        }
    }
}