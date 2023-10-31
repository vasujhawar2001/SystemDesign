package BowlingAlley;

import java.util.Arrays;

public class ScoreBoardImpl implements ScoreBoard{
    private int[] points;
    private Integer currRoll = 0;
    private Integer currScore = 0;
    public ScoreBoardImpl(){
        points = new int[Constants.MAX_ROLLS];
    }

    @Override
    public void roll(Integer pinsDown) {

        if(currRoll==Constants.MAX_ROLLS){
            return;
        }
        if(currRoll>0 && currRoll%2==1 && points[currRoll-1]+pinsDown>10){
            pinsDown = (int)(Math.random()*(10-points[currRoll-1]));     // handling for random test cases
        }
        points[currRoll] = pinsDown;
        currRoll++;
    }

    // to get the total score of the player;
//    @Override
    public Integer getScore() {
        int total = 0;
        int roll = 0;
        for(int i=0; i<Constants.TOTAL_SETS; i++){
            if(isStrike(roll)){
                total += Constants.MAX_PINS + 10;
            }
            else if(isSpare(roll)){
                total += Constants.MAX_PINS + 5;
            }
            else{
                total += points[roll]+points[roll+1];
            }
            //shift the round
            roll += 2;
        }
        return total + points[roll]; // for last bonus roll
    }
    public Integer getCurrScore(){
        return currScore;
    }

    public Integer getScoreAt(int rollIndex){
        //returns point at particular roll
        return points[rollIndex];
    }

    private boolean isSpare(int roll) {
        return points[roll]+points[roll+1]==10;
    }

    private boolean isStrike(int roll) {
        return points[roll]==10;
    }

    public void printPoints(){
        System.out.println(Arrays.toString(points));
    }
}
