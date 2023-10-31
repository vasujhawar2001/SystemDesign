package SnakeAndLadder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Game {
    Board board;
    Dice dice;
    ArrayDeque<Player> playersList;

    public Game(int boardSize, int diceCount){
        this.board = new Board(boardSize, true);  // or use the computer made Board - need to be implemented using Math.random() methods
        this.dice = new Dice(diceCount, false);  // can have 1,2,3 or more dice
        this.playersList = addPlayersfromConsole();
    }

    public void startGame() {
        int win = 1;
        while(playersList.size()>1){
            Player currPlayer = playersList.removeFirst();
            // now we roll the dice
            int roll = dice.rollDice();
            int currPosition = currPlayer.getCurrentPosition();
            int newPosition = currPosition + roll;
            if(newPosition>= board.boardSize * board.boardSize){
                // player wins the game
                System.out.println(currPlayer.playerName+" rolled a "+roll);
                System.out.println(currPlayer.playerName+" wins the game "+(win++)+"st");
                continue;
            }
            if(board.jumpMap.containsKey(newPosition)){
                // here we have snake or ladder, depending upon start and end
                int start = newPosition;
                int end = board.jumpMap.get(start);
                // start>end -> snake
                if(start>end) System.out.println("OH NO, SNAKE BITE, sssss");
                if(end>start ) System.out.println("Hurray, got a LADDER, climb up.");
                //end>start -> ladder
                currPlayer.setCurrentPosition(end);
            }
            else{
                currPlayer.setCurrentPosition(newPosition);
            }
            System.out.println(currPlayer.playerName+" rolled a "+roll+" and moved from "+currPosition+" to "+currPlayer.getCurrentPosition());
            playersList.add(currPlayer);
        }
    }

    private ArrayDeque<Player> addPlayersfromConsole() {
        System.out.println("Enter the number of players:");
        Scanner sc = new Scanner(System.in);
        int players = sc.nextInt();
        ArrayDeque<Player> list = new ArrayDeque<>();
        int id=1;
        while(players>0){
            list.add(new Player(id++, sc.next(),1));
            players--;
        }
        return list;
    }
}
