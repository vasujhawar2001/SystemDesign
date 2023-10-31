package SnakeAndLadder;

public class Player {
    int id;
    String playerName;
    private int currentPosition;

    public Player(int id, String name, int currentPosition){
        this.currentPosition = currentPosition;
        this.id = id;
        this.playerName = name;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }
    public void setCurrentPosition(int position){
        this.currentPosition = position;
    }
}
