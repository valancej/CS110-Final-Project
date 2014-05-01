/*Runs a simulation of the card game war */

import java.util.Scanner;

public class Simulation
{
	int totalGames;
	int totalBattles;
	int totalWars;
	int totalDoubleWars;
	int maxBattles;
	int minBattles;
	int maxWars;
	int minWars;
	int avgBattles;
	int avgWars;
	int avgDoubleWars;
	
	public Simulation(int numGames)
	{
		totalGames = numGames;
		totalBattles = 0;
		totalWars = 0;
		totalDoubleWars = 0;
		maxBattles = Integer.MIN_VALUE;
		minBattles = Integer.MAX_VALUE;
		maxWars = Integer.MIN_VALUE;
		minWars = Integer.MAX_VALUE;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		if(args.length == 0 || args.length > 1)
		{
			System.out.println("Incorrect Number of Arguments");
			System.out.println("Proper usage:");
			System.out.println("\tArgument 1: Number of Games to Play");
			input.nextLine();
			System.exit(0);
		}
		
		int numGames = Integer.parseInt(args[0]);
		
		Simulation simulator = new Simulation(numGames);
		
		simulator.simulate();
		simulator.calculate();
		simulator.report();
		
		System.out.println("\nPress Enter to Exit.");
		input.nextLine();
	}
	
	public void simulate()
	{
		for(int i = 0; i < totalGames; i++)
		{
			Game newGame = new Game();
			newGame.playGame();
			
			totalBattles += newGame.getNumBattles();
			totalWars += newGame.getNumWars();
			totalDoubleWars += newGame.getNumDoubleWars();
			
			if(newGame.getNumBattles() < minBattles)
				minBattles = newGame.getNumBattles();
			if(newGame.getNumBattles() > maxBattles)
				maxBattles = newGame.getNumBattles();
			if(newGame.getNumWars() < minWars)
				minWars = newGame.getNumWars();
			if(newGame.getNumWars() > maxWars)
				maxWars = newGame.getNumWars();
		}
	}
	
	public void calculate()
	{
		avgBattles = (totalBattles / totalGames);
		avgWars = (totalWars / totalGames);
		avgDoubleWars = (totalDoubleWars / totalGames);
	}
	
	public void report()
	{
		System.out.println("For a set of " + totalGames + " games:");
		System.out.println("\tAverage number of battles per game: " + avgBattles);
		System.out.println("\tAverage number of wars per game: " + avgWars);
		System.out.println("\tAverage number of double wars per game: " + avgDoubleWars);
		System.out.println("\tMax number of battles in a game: " + maxBattles);
		System.out.println("\tMin number of battles in a game: " + minBattles);
		System.out.println("\tMax number of wars in a game: " + maxWars);
		System.out.println("\tMin number of wars in a game: " + minWars);
	}
}
