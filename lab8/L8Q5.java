import java.util.*;

public class L8Q5 {
    public static void main(String[] args) {
        Game player1 = new Game();
        Game player2 = new Game();
        while (true)
        {
            player1.move();
            System.out.println(player1.name + "'s score: " + player1.score);
            if (player1.score >= 100)
            {
                System.out.println(player1.name + " wins!");
                break;
            }

            player2.move();
            System.out.println(player2.name + "'s score: " + player2.score);
            if (player2.score >= 100)
            {
                System.out.println(player2.name + " wins!");
                break;
            }
        }  
    }
}

class Game {
    String name;
    int score;
    Scanner sc = new Scanner(System.in);

    public Game()
    {
        System.out.print("Enter player name: ");
        String playerName = sc.nextLine();
        name = playerName;
        score = 0;
    }

    public void move()
    {
        Random rand = new Random();
        int move = rand.nextInt(6) + 1;
        score += move;
    }
}
