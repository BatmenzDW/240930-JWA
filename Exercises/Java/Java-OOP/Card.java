public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
    }

    public Card(Value value)
    {
        this.value = value;
        this.suit = null;
    }

    public Suit getSuit(){
        return suit;
    }

    public Value getValue(){
        return value;
    }

    public String toString(){
        return ColorUtil.WHITE_BACKGROUND + suit.getColor() + suit.getSymbol() + value.getValue() + ColorUtil.RESET;
    }

    private Card cardValueOf(){
        return new Card(value);
    }

    public static Card valueOf(Card card)
    {
        return card.cardValueOf();
    }

    public boolean sharesValue(Card card)
    {
        return value.equals(card.getValue());
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Card other){
            if (suit == null && other.getSuit() == null)
            {
                return value == other.getValue();
            }
            return suit == other.getSuit() && value == other.getValue();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return (suit == null ? 0 : suit.hashCode()) + value.hashCode();
    }
}
