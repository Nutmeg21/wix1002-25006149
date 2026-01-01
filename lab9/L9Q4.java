import java.util.*;

public class L9Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Player 1: ");
        String player1 = sc.nextLine();
        System.out.println("Enter player 2: ");
        String player2 = sc.nextLine();

        DoubleDice game1 = new DoubleDice(player1, player2);
        System.out.println("Double dice - Game starting...");
        while (game1.score1 < 100 && game1.score2 < 100)
        {
           game1.move();
        }

        Sixes game2 = new Sixes(player1, player2);
        System.out.println("Sixes - Game starting...");
        while (game2.score1 < 100 && game2.score2 < 100)
        {
            game2.move();
        }
        sc.close();   
    }
}

class Game {
    String name1;
    String name2;
    int score1;
    int score2;

    public Game(String player1, String player2)
    {
        name1 = player1;
        name2 = player2;
    }
}

class DoubleDice extends Game {
    public DoubleDice(String player1, String player2)
    {
        super(player1, player2);
    }

    public void move()
    {
        Random rand = new Random();
        int move1, move2;
        do {
            move1 = rand.nextInt(6) + 1;
            move2 = rand.nextInt(6) + 1;
            score1 += move1 + move2;
            System.out.println(name1 + "'s score: " + score1);
            if (score1 >= 100)
            {
                System.out.println(name1 + " wins!");
                return;
            }
        } while (move1 == move2);

        do {
            move1 = rand.nextInt(6) + 1;
            move2 = rand.nextInt(6) + 1;
            score2 += move1 + move2;
            System.out.println(name2 + "'s score: " + score2);
            if (score2 >= 100)
            {
                System.out.println(name2 + " wins!");
                return;
            }
        } while (move1 == move2);
    }
}

class Sixes extends Game {
    public Sixes(String player1, String player2)
    {
        super(player1, player2);
    }

    public void move()
    {
        Random rand = new Random();
        int move = rand.nextInt(6) + 1;
        if (move == 6)
        {
            move += rand.nextInt(6) + 1;
            if (move == 12)
            {
                move = 0;
            }
        }
        score1 += move;
        if (score1 > 100)
        {
            score1 -= move;
        }
        System.out.println(name1 + "'s score: " + score1);
        if (score1 == 100)
        {
            System.out.println(name1 + " wins!");
            return;
        }

        move = rand.nextInt(6) + 1;
        if (move == 6)
        {
            move += rand.nextInt(6) + 1;
            if (move == 12)
            {
                move = 0;
            }
        }
        score2 += move;
        if (score2 > 100)
        {
            score2 -= move;
        }
        System.out.println(name2 + "'s score: " + score2);
        if (score2 == 100)
        {
            System.out.println(name2 + " wins!");
            return;
        }
    }
}