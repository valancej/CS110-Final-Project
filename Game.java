import java.util.LinkedList;

public class Game
{
	//Statistics
	int numBattles;
	int numWars;
	int numDoubleWars;
	int gameWinner;
	
	Deck deck;
	Player playerOne;
	Player playerTwo;
	
	//Piles for flipped cards.
	LinkedList<Card> playerOnePile = new LinkedList<Card>();
	LinkedList<Card> playerTwoPile = new LinkedList<Card>();
	
	public Game()
	{
		numBattles = 0;
		numWars = 0;
		numDoubleWars = 0;
		gameWinner = 0;
		
		deck = new Deck();
		playerOne = new Player(1);
		playerTwo = new Player(2);
	}
	
	public int getNumBattles()
	{
		return numBattles;
	}
	
	public int getNumWars()
	{
		return numWars;
	}
	
	public int getNumDoubleWars()
	{
		return numDoubleWars;
	}
	
	public int getWinner()
	{
		return gameWinner;
	}
	
	public void playGame()
	{		
		//Deal Cards
		while(deck.getSize() > 0)
		{
			playerOne.collect(deck.deal());
			playerTwo.collect(deck.deal());
		}
		
		while(gameWinner == 0)
		{
			//Flip Cards
			playerOnePile.addFirst(playerOne.flip());
			playerTwoPile.addFirst(playerTwo.flip());
			
			int battleWinner = playerOnePile.getFirst().compare(playerTwoPile.getFirst());
			numBattles++;
			
			if(battleWinner == 0)
			{
				//War!
				numWars++;
				battleWinner = war();
			}
			
			int randomAddOrder = (int)(Math.random() * 2); //Random add order prevents infinite loops from occurring.
			
			if(battleWinner > 0)
			{
				if(randomAddOrder == 1)
				{
					playerOne.collectPile(playerOnePile);
					playerOne.collectPile(playerTwoPile);
				}
				else
				{
					playerOne.collectPile(playerTwoPile);
					playerOne.collectPile(playerOnePile);
				}
			}
			else if(battleWinner < 0)
			{
				if(randomAddOrder == 1)
				{
					playerTwo.collectPile(playerOnePile);
					playerTwo.collectPile(playerTwoPile);
				}
				else
				{
					playerTwo.collectPile(playerTwoPile);
					playerTwo.collectPile(playerOnePile);
				}
			}
			
			if(playerOne.hasWon())
				gameWinner = 1;
			else if(playerTwo.hasWon())
				gameWinner = 2;
		}
	}
	
	private int war()
	{
		//Flip 3 + 1 for War
		for(int i = 0; playerOne.getNumCards() > 0 && i < 4; i++)
			playerOnePile.addFirst(playerOne.flip());
		for(int i = 0; playerTwo.getNumCards() > 0 && i < 4; i++)
			playerTwoPile.addFirst(playerTwo.flip());
		
		int warWinner = playerOnePile.getFirst().compare(playerTwoPile.getFirst());
		
		if(warWinner == 0)
		{
			//Double War!
			numDoubleWars++;
			warWinner = war();
		}
		
		return warWinner;
	}
}
