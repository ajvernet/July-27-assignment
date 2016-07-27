package com.batting_stats;

import java.util.ArrayList;
import java.util.Scanner;

public class BattingStats 
{
	private ArrayList<Integer> batResults = new ArrayList<>();
	
	public BattingStats()
	{}
	
	public void addResult(Integer numBases)
	{
		if (numBases >= 0 && numBases <= 4)
		{
			batResults.add(numBases);
		} else
			System.out.println("Base number must be between 0 and 4.");
	}
	public Float getSluggingPercentage()
	{
		Float result = 0.0f;	
		for(Integer i: batResults)
		{			
			result += i;
		}		
		return result * 100;
	}
	
	public Float getBattingAverage()
	{
		Float numSuccessess = 0.0f;	
		for(Integer i: batResults)
		{
			if (i > 0) numSuccessess++;
		}		
		return numSuccessess / batResults.size();
	}
	
	public void printAverages()
	{
		System.out.format("Batting Average: %.3f", getBattingAverage());
		System.out.format("\nSlugging Percentage: %% %.3f", getSluggingPercentage());
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String input;
		int numAtBats;
		boolean isFinished = false;
		
		while(!isFinished)
		{
			System.out.println("Please enter the number of at-bats for a given player."
					+ " (valid entries are 1 - 10)");
			
			input = sc.next();		
			
			numAtBats = Integer.parseInt(input);
			
			//check that number of at-bats is valid.  If not, return to the beginning of the loop.
			if (!(0 < numAtBats && numAtBats < 11)) 
				{
					System.out.println("Invalid entry");
					continue;
				}
				
			// prompt the user for the number of bases for each at-bat.
			else 
			{
				int numBases;
				BattingStats newPlayer = new BattingStats();
				
				for(int i = 0; i < numAtBats; i++)
				{
					System.out.println("Please enter the number of bases for at bat #" + (i + 1)
							+ ": ");
					
					numBases = Integer.parseInt(sc.next());
					
					//if an erroneous number of bases is input,
					//then the iterator decreases to ensure all 
					// at-bats are correctly addressed.
					
					if (0 > numBases || numBases > 4) i--;
					
					newPlayer.addResult(numBases);
				}
				
				newPlayer.printAverages();
			}
			
			// only entries "y, Y, n, or N are accepted input at the end of the iteration.
			// check for input and respond accordingly.
			boolean validEntry = false;
			while(!validEntry){
			System.out.println("Another batter? Please enter Y or N: ");
			input = sc.next();
			
				//if entry is not valid, sends error message to user, and requests
				// a new input.
				if(!((input.equalsIgnoreCase("N")) || input.equalsIgnoreCase("Y")))
				{
					System.out.println("Invalid entry.  Valid inputs are Y or N: ");
					System.out.println();
				}
				
				// if input is N, exit the main loop
				else if( input.equalsIgnoreCase("N")) 
					{
						System.out.println("Thanks for using the Batting Average program!");
						isFinished = true;
						break;
					}
				
				// if input is Y, return to the beginning of the main loop.
				else if(input.equalsIgnoreCase("Y")) break;
			}
		}
	}
	
	
}
