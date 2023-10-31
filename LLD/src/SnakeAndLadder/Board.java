package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
    Map<Integer, Integer> jumpMap;  // containing start -> end key value pairs
    int boardSize;
    int snakes;
    int ladders;

    public Board(int boardSize, int snakes, int ladders){
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
        jumpMap = new HashMap<>();
        initializeBoardWithComputer();
    }

    private void initializeBoardWithComputer() {
        // will code later
    }

    public Board(int boardSize, boolean userInput){
        this.boardSize = boardSize;
        jumpMap = new HashMap<>();
        if(userInput){
            initializeBoardWithUserInput();
        }
    }

    private void initializeBoardWithUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Snakes you want:");
        int snakes = sc.nextInt();
        this.snakes = snakes;
        while(snakes>0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            //put the jump in map
            jumpMap.put(start, end);
            snakes--;
        }
        System.out.println("Enter the number of Ladders you want:");
        int ladders = sc.nextInt();
        this.ladders = ladders;
        while(ladders>0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            //put the jump in map
            jumpMap.put(start, end);
            ladders--;
        }
    }
}

