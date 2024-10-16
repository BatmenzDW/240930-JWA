import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerAgent extends Agent {

    private List<String> valid;


    @Override
    public void takeTurn() {

        System.out.println("Hand:");
        printHand();

        System.out.println("Score: " + Game.getInstance().getScore(this));

        System.out.println("Choose a card value to request.");
        String value;

        do 
        {
            value = Game.scanner.nextLine();
        } while (!valid.contains(value));
        
        // System.out.println("Chose " + value);
        int val = value.equals("A") ? 14 : value.equals("K") ? 13 : value.equals("Q") ? 12 : value.equals("J") ? 11 : -1;
        // System.out.println("Chose " + val);
        if (val == -1) val = Integer.parseInt(value);
        val -= 2;

        Card request = new Card(Value.values()[val]);

        Card requested = requestCard(request);

        if (requested != null)
        {
            System.out.println("Took " + requested + " from other player.");
            addCard(requested);
            takeTurn();
        }
        else 
        {
            System.out.println("Go Fish.");
            goFish();
        }
    }

    public PlayerAgent(String name)
    {
        this.name = name;
        valid = new ArrayList<String>();
        String[] v = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        valid.addAll(Arrays.asList(v));
    }
}
