package SnakeAndLadder;

public class Dice {
    int diceCount;
    boolean bonusMove;
    public Dice(int diceCount, boolean bonusMove){
        this.diceCount = diceCount;
        this.bonusMove = bonusMove;
    }

    public int rollDice(){
        int total=0;
        int dices=0;
        int bonus = 0;
        while(dices<diceCount){
            int diceMove = diceMove();
            if(diceMove==6 && bonusMove){  // these conditions will work only if we enable bonsuMove
                System.out.println("BONUSES ON: You rolled 6, got one more chance.");
                bonus++;
                dices--; // you get one more turn
            }
            total += diceMove;
            dices++;
        }
        if(bonusMove && bonus==3){
            System.out.println("THREE TIMES 6, YOU GET 0.");
            return 0;
        }
        return total;
    }

    private int diceMove(){
        return (int)(Math.random() * 6) + 1;
    }
}
