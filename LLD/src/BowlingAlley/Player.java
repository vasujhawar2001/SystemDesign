package BowlingAlley;

public class Player {
    private int id;
    private String playerName;
    private final ScoreBoard scoreBoard;
    private boolean isWinner;

    public Player(int id, String name, ScoreBoard scoreBoard){
        this.id = id;
        this.playerName = name;
        this.scoreBoard = scoreBoard;
        this.isWinner = false;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public int getId(){
        return id;
    }
    public void setWinner(boolean win){
        this.isWinner = win;
    }
    public boolean getWin(){
        return isWinner;
    }
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", score=" + scoreBoard.getScore()+
                ", isWin=" + isWinner +
                '}';
    }
}
