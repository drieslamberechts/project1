// SINGLETON CLASS
// ------------------------------------

// hi dries

package com.EminusStudios.theunnamed;

public class GameManager
{
	private static GameManager INSTANCE;
	
	// VARIABLES
	
	private int mCurrentScore = 0;
	private static final int INITIAL_SCORE = 0;
	
	//The constructor does not do anything for this singleton
	GameManager()
	{
	}
	
	public static GameManager GetInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new GameManager();
		}
		return INSTANCE;
	}
	
	// ---------------------------------------------------------------
	// FILL IN THE DATA THAT HAS TO BE REMEMBERED THROUGHOUT THE GAME (GETTERS AND SETTERS)
	// ---------------------------------------------------------------
	
	// EXAMPLE
	// Get the current score
	public int getCurrentScore()
	{
		return this.mCurrentScore;
	}
	
	// Resetting the game simply means we must revert back to initial values.
	public void resetGame()
	{
		this.mCurrentScore = GameManager.INITIAL_SCORE;
	}
}