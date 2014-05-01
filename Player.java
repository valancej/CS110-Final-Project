import java.util.LinkedList;

public class Player
{
	int playerNumber;
	LinkedList<Card> ownedCards;
	
	public Player(int playerNumber)
	{
		this.playerNumber = playerNumber;
		ownedCards = new LinkedList<Card>();
	}
	
	public Card flip()
	{
		return ownedCards.removeFirst();
	}
	
	public void collect(Card newCard)
	{
		ownedCards.addLast(newCard);
	}
	
	public int getNumCards()
	{
		return ownedCards.size();
	}
	
	public boolean hasWon()
	{
		if(ownedCards.size() >= 52)
			return true;
		return false;
	}
	
	public void collectPile(LinkedList<Card> pile)
	{
		while(pile.size() > 0)
			collect(pile.removeFirst());
	}
}
