import java.util.ArrayList;
import java.util.Scanner;

public class SkunkPlayer
{
	private String player_name;
	private int playerTotalScore;
	private ArrayList<Turn> game_turn;
	private int numOfTurn;
	private Round game_round;
	private boolean status;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		playerTotalScore = 0;
		game_turn = new ArrayList<Turn>();
		numOfTurn = 0;
		game_round = new Round();
		status = false;
	}
			
	public void add_to_round(ArrayList<Turn> theTurn) {
		Turn aTurn = game_round.createTurn();
		theTurn.add(aTurn);
		game_turn = theTurn;
	}
	
	public String getName() 
	{
		return player_name;
	}

	//for testing
	public int scoreUpdate_test() 
	{
		playerTotalScore = game_round.getRound_Score();
		return playerTotalScore;
	}
	
	//update score after turn
	//any addition turn should only add to existing score but not calculate from beginning again
	public int scoreUpdate() 
	{
		/*for(int x=0 ; x < gameTurn.size() ; x++) 
		{
			playerTotalScore = gameTurn.get(x).addScore();
		}
		*/
		playerTotalScore = game_round.getRound_Score();
		return playerTotalScore;
	}
	
	//getter for playerScore
	public int getScore() 
	{ 
		playerTotalScore = scoreUpdate();
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
		return status;	
	}
		
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	//make current player status off and switch turn to another player
	public void switchPlayer() {
		status = false;
	}

}
