import java.util.ArrayList;
import java.util.Scanner;

//in game class, track players

public class SkunkPlayer
{
	private String player_name;
	private int playerTotalScore;
	private ArrayList<Turn> gameTurn;
	private int numOfTurn;
	private boolean status;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		playerTotalScore = 0;
		gameTurn = new ArrayList<Turn>(100);
		status = false;
	}
	
	public Turn createTurn() 
	{
		status = true;
		Turn aTurn = new Turn();
		numOfTurn++;
		gameTurn.add(aTurn);
		return aTurn;
	}
	
	public String getName() 
	{
		return player_name;
	}

	//for testing
	public int scoreUpdate_test() 
	{
		for(int x=0 ; x < gameTurn.size() ; x++) 
		{
			playerTotalScore = playerTotalScore + gameTurn.get(x).addScore_test();
		}
		return playerTotalScore;
	}
	
	//update score after turn
	public int scoreUpdate() 
	{
		for(int x=0 ; x < gameTurn.size() ; x++) 
		{
			playerTotalScore = playerTotalScore + gameTurn.get(x).addScore();
		}
		return playerTotalScore;
	}
	
	//for testing
	public int getScore_test() 
	{ 
		return playerTotalScore;
	}
	
	//getter for playerScore
	public int getScore() 
	{ 
		return playerTotalScore;
	}
	
	public int getNumOfTurn() 
	{
		return numOfTurn;
	}

	public void setPlayerTotalScore(int playerTotalScore)
	{
		this.playerTotalScore = playerTotalScore;
	}
	
	public boolean turnStatus() {
		return true;	
	}
	
	//make current player status off and switch turn to another player
	public boolean switchPlayer() {
		status = false;
		return status;
	}

}


