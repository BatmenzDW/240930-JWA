import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardPile = new ArrayList<>();

    public Deck()
    {
        for (Suit suit: Suit.values())
        {
            for (Value value: Value.values())
            {
                cardPile.add(new Card(suit, value));
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cardPile);
    }

    public Card drawCard(){
        return cardPile.remove(0);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Card card : cardPile) {
            sb.append(card);
        }
        return sb.toString();
    }
}
