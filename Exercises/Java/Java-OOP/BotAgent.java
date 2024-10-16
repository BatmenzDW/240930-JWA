import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class BotAgent extends Agent {

    private List<Card> opponentHistory = new ArrayList<>();
    private List<Card> history = new ArrayList<>();

    @Override
    public void takeTurn() {
        Card chosen = chooseCard();

        history.add(chosen);

        takeTurn(chosen);
    }

    public void takeTurn(Card card)
    {
        Card requested = requestCard(card);

        if (requested != null)
        {
            System.out.println(name + " Took " + requested + " from player.");
            addCard(requested);
            takeTurn(card);
        }
        else
        {
            System.out.println(name + " Went Fish.");
            goFish();
        }
    }

    @Override
    public Card cardRequested(Card card) {
        for (Card hCard: hand)
        {
            if (hCard.sharesValue(card))
            {
                opponentHistory.add(Card.valueOf(card));
                hand.remove(hCard);
                return hCard;
            }
        }
        return null;
    }

    public BotAgent(String name)
    {
        this.name = name;
    }

    private Card chooseCard()
    {
        List<Card> consider = new ArrayList<>();
        for (Card c : hand) 
        {
            Card cV = Card.valueOf(c);
            if (opponentHistory.contains(cV))
            {
                return cV;
            }
            else if (!history.contains(cV))
            {
                consider.add(cV);
            }
        }

        if (consider.size() > 0)
            return consider.get(0);

        if (!cardCount.isEmpty())
        {
            int max = 0;
            Card maxChoice = new Card(Value.ACE);
            for (Entry<Card,Integer> entry : cardCount.entrySet()) {
                if (entry.getValue() > max)
                {
                    max = entry.getValue();
                    maxChoice = entry.getKey();
                }
            }
            return maxChoice;
        }
        return new Card(Value.ACE);
    }
}
