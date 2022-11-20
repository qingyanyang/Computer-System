import java.util.LinkedList;
public class Club {
    LinkedList<Player> members;

    public Club() {
        members = new LinkedList<Player>();
    }
    void addMember(Player member){
        if(this.members.size() == 0){
            this.members.add(member);
        }else{
            int len = members.size();
            while (len > 0 && member.getName().compareTo(members.get(len - 1).getName()) < 0){
                len--;
            }
            if(0 < len && len == members.size()){
                members.add(member);
            }else{
                members.add(len, member);
            }
        }
    }
    boolean removeMemberById(int id){
        if(this.members.size() != 0){
            for(int i = 0; i < this.members.size(); i++){
                if(this.members.get(i).getId() == id) {
                    this.members.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    Player getHighestRankedPlayer(){
        if(this.members == null){
            return null;
        }else{
            int max = 0;
            for(int i = 0; i < (this.members.size() - 1); i++){
                if(members.get(max).getRanking() < members.get(i + 1).getRanking()){
                    max = i + 1;
                }else if(members.get(max).getRanking() == members.get(i + 1).getRanking()){
                    if(members.get(max).getAge() > members.get(i + 1).getAge()){
                        max = i + 1;
                    }
                }
            }
            return members.get(max);
        }
    }
    void printMembers(){
        for(int i = 0; i < this.members.size(); i++){
            System.out.println(members.get(i).toString());
        }
    }
    void countMembers(){
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < members.size(); i++){
            if(members.get(i).getAge() < 21){
                count1++;
            }
            if(members.get(i).getAge() >= 21){
                count2++;
            }
        }
        System.out.println("The club has " + count1 + "junior and " + count2 + "senior members");
    }
    Player getHighestRankedJunior(){
        int len = this.members.size();
        int count1 = 0;
        for(int i = 0; i < len; i++) {
            if (members.get(i).getAge() < 21) {
                count1++;
            }
        }
        Player[] arr = new Player[count1];
        if(count1 == 0){
            return null;
        }else{
            for(int i = 0; i < count1 - 1; i++){
                if(arr[i].getRanking() < arr[i + 1].getRanking()){
                    Player tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            return arr[0];
        }
    }
}
