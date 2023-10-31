package BowlingAlley;

public interface ScoreBoard {
    void roll(Integer noOfPins);

    Integer getCurrScore();

    Integer getScoreAt(int indexOfRoll);

    void printPoints();

    Integer getScore();
}
