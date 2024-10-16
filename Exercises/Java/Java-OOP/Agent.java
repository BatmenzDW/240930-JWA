import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Agent {
    protected List<Card> hand = new ArrayList<>();
    protected Map<Card, Integer> cardCount = new HashMap<>();
    protected int score = 0;

    public String name = "agent";

    public abstract void takeTurn();

    public void goFish() {
        Card drawn = Game.getInstance().getDeck().drawCard();
        boolean caught = addCard(drawn);

        if (caught) takeTurn();
    }

    public Card requestCard(Card card) {
        return Game.getInstance().sendCardRequest(this, card);
    };
    
    public Card cardRequested(Card card) {
        for (Card hCard: hand)
        {
            if (hCard.sharesValue(card))
            {
                hand.remove(hCard);
                return hCard;
            }
        }
        return null;
    }

    public int getScore(){
        return score;
    }

    public boolean addCard(Card card){
        hand.add(card);
        Card val = Card.valueOf(card);
        int count = cardCount.getOrDefault(val, 0) + 1;
        // System.out.println(name + " has " + count + " " + val.getValue());

        if (count >= 4)
        {
            score += 1;
            cardCount.remove(val);

            for (int i = 0; i < hand.size(); i++)
            {
                Card hCard = hand.get(i);
                if (Card.valueOf(hCard).equals(val))
                {
                    hand.remove(hCard);
                    i -= 1;
                }
            }
            return true;
        }
        else
        {
            cardCount.put(val, count);
            return false;
        }
    }

    public void printHand()
    {
        // System.out.println();
        for (Card card: hand)
        {
            System.out.print(card);
            System.out.print(" ");
        }
        System.out.println();
    }
}
