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
        //create new instance of class ShakingParty
        ShakingParty party1 = new ShakingParty();
        //call countHandShakes method
        int handShakeTimes = party1.countHandShakes(party1.getNPeople());
        System.out.println("The party had " + party1.getNPeople() + " people");
        System.out.println(handShakeTimes + " hand-shakes happened");
    }
}