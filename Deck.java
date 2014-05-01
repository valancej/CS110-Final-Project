import java.util.LinkedList;

public class Deck
{
	LinkedList<Card> deck;
	
	public Deck()
	{
		deck = new LinkedList<Card>();
		for(int suit = 1; suit <= 4; suit++)
			for(int value = 2; value <= 14; value++)
				deck.addLast(new Card(suit, value));
	}
	
	public Card deal()
	{
		int random = (int)(deck.size() * Math.random());
		return deck.remove(random);
	}
	
	public int getSize()
	{
		return deck.size();
	}
}
