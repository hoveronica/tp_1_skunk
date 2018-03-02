import java.util.ArrayList;

//in game class, track players

public class SkunkPlayer
{
	private String player_name;
	private int playerTotalScore;
	private ArrayList<Turn> gameTurn;
	private int numOfTurn;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		playerTotalScore = 0;
		gameTurn = new ArrayList<Turn>(100);
	}
	
	public Turn createTurn() 
	{
		Turn aTurn = new Turn();
		numOfTurn++;
		gameTurn.add(aTurn);
		return aTurn;
	}
	
	public String getName() 
	{
		return player_name;
	}

	//update score after turn
	public int scoreUpdate() 
	{
		for(int x=0 ; x < gameTurn.size()-1 ; x++) 
		{
			playerTotalScore = playerTotalScore + gameTurn.get(x).getTurnScore();
		}
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
}


