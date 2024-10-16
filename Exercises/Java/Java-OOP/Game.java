import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Game instance;
    public static Scanner scanner;

    private final int winningScore;

    private List<Agent> players = new ArrayList<>();
    private Deck deck;
    private boolean gameOver = false;

    public static Game getInstance()
    {
        return instance;
    }

    public static void startGame(int winScore)
    {
        instance = new Game(winScore);

        instance.dealCards();

        instance.gameLoop();
    }

    public static void main(String[] args)
    {
        Game.startGame(13);
    }

    private Game(int winningScore)
    {
        this.winningScore = winningScore;

        scanner = new Scanner(System.in);

        System.out.println("Choose number of human players:");
        int playerCount = scanner.nextInt();

        System.out.println("Choose number of ai players:");
        int botCount = scanner.nextInt();

        deck = new Deck();
        // System.out.println(deck);

        for (int i = 0; i < playerCount; i++)
        {
            players.add(new PlayerAgent("Player " + (i+1)));
        }

        for (int i = 0; i < botCount; i++)
        {
            players.add(new BotAgent("Bot " + (i+1)));
        }

        // Collections.shuffle(players)
    }

    private void gameLoop()
    {
        int p = 0;
        while (!gameOver)
        {
            System.out.println(players.get(p).name + "'s turn.");
            players.get(p).takeTurn();

            if (players.get(p).getScore() >= winningScore)
            {
                gameOver = true;
            }

            p = (p+1)%players.size();
            System.out.println();
        }
        System.out.println("Winner is player " + p);
    }

    private void dealCards()
    {
        int cardsInHand = 0;
        int handSize = players.size() <= 2 ? 7 : 5;

        while (cardsInHand < handSize)
        {
            for (Agent agent: players)
            {
                agent.addCard(deck.drawCard());
            }
            cardsInHand += 1;
        }
    }

    public Card sendCardRequest(Agent sender, Card request)
    {
        if (players.size() != 2) throw new UnsupportedOperationException("Not implemented for current player count.");

        for (Agent agent: players)
        {
            if (agent.equals(sender)) continue;

            return agent.cardRequested(request);
        }

        return null;
    }

    public Deck getDeck(){
        return deck;
    }

    public String getScore(Agent requester)
    {
        StringBuilder sb = new StringBuilder();

        Agent opponent = null;

        for (Agent agent: players)
        {
            if (agent.equals(requester)) sb.append(agent.getScore());
            else opponent = agent;
        }
        sb.append(":");
        sb.append(opponent.getScore());

        return sb.toString();
    }

    // public void sendCardRequest(Agent sender, Agent target, Card request)
    // {

    // }
}
