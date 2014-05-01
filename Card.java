
public class Card
{
	int suit;
	int value;
	
	public Card(int suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
	
	public int getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int compare(Card compareCard)
	{
		if(value > compareCard.getValue())
			return 1;
		else if(value < compareCard.getValue())
			return -1;
		else
			return 0;
	}
}
