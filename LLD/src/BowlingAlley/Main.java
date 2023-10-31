package BowlingAlley;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1,"Vasu", new ScoreBoardImpl());
        Player p2 = new Player(2, "Rahul", new ScoreBoardImpl());

        List<Player> players = Arrays.asList(p1,p2);
        BowlingLaneService bowlingGameService = new BowlingLaneService(players);

        bowlingGameService.startGame();

        p1.getScoreBoard().printPoints();
        System.out.println(p1.getScoreBoard().getScore());
        p2.getScoreBoard().printPoints();
        System.out.println(p2.getScoreBoard().getScore());
        System.out.println(bowlingGameService.getWinner());
    }
}
