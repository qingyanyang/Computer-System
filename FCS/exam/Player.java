public class Player extends Person {
    static int numPlayers;
    int id;
    int numWins;
    int numPlayed;

    public Player(String name, int age, int numWins, int numPlayed) {
        super(name, age);
        this.numWins = numWins;
        this.numPlayed = numPlayed;
        this.numPlayers++;
        this.id = this.numPlayers;
    }
    void lose(){
        this.numPlayed++;
    }
    void win(){
        this.numWins++;
        this.numPlayed++;
    }
    int getRanking(){
        if(this.numPlayed != 0){
            return this.numPlayed * (this.numWins / this.numPlayed);
        }
        return 0;
    }
    int getId(){
        return this.id;
    }
    public String toString(){
        return super.toString() + "Id: " + this.id + " Ranking: " + this.getRanking();
    }
}
