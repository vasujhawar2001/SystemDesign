package BowlingAlley;

import java.util.List;

public class BowlingLaneService {
    List<Player> players;
    Player winner;

    public BowlingLaneService(List<Player> players){
        this.players = players;
    }
    public void startGame(){

        // for each set/round, each player will play and update their currScore
        for(int i=0; i<Constants.TOTAL_SETS; i++){

            for(Player player : players) {
                int standingPins = Constants.MAX_PINS;
                int numPinsDown = bowl(standingPins);
                ScoreBoard sb = player.getScoreBoard();
                sb.roll(numPinsDown);


                    standingPins -= numPinsDown;
                    int secondBowl = bowl(standingPins);
                    sb.roll(secondBowl); //2nd chance to roll in the same set;


                if(i==Constants.TOTAL_SETS-1){
                    // checking for the last set if it was a strike/spare
                    if(sb.getScoreAt(Constants.MAX_ROLLS-2)+sb.getScoreAt(Constants.MAX_ROLLS-3)==10){
                        // YOU GET ONE MORE CHANCE
                        standingPins  = Constants.MAX_PINS;
                        sb.roll(standingPins);
                    }
                }
            }
        }
    }

    private int bowl(int standingPins) {
        return (int)(Math.random()*(standingPins+1));
    }

    public String getWinner(){
        int maxScore = 0;
        for(Player player: players){
            if(player.getScoreBoard().getScore()>maxScore){
                winner = player;
                maxScore = player.getScoreBoard().getScore();
            }
        }
        winner.setWinner(true);
        return winner.toString();
    }

}
