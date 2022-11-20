//==================================
// Foundations of Computer Science
// Student: qingyan yang
// id: a1865304
// Semester: s01
// Year: 2022
// Practical Number: 04
//===================================
class Test{
    public static void main(String[] args){
        //instance of DiskLength to get user's input
        DiskLength d = new DiskLength();
        int n = d.inputLength();
        //instance of HanoiTowerIterative to call loop method
        HanoiTowerIterative h = new HanoiTowerIterative(n);
        h.loop(n, h.listPoleS, h.listPoleT, h.listPoleD, h.poleS, h.poleT, h.poleD);
    }
}