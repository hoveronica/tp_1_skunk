import java.util.ArrayList;
import java.util.Scanner;

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
		gameTurn = new ArrayList<Turn>();
		numOfTurn = 0;
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
	
	public int scoreUpdate() 
	{
		if (gameTurn.size()==0) return 0;
		playerTotalScore = 0;
		Turn final_turn = gameTurn.get(gameTurn.size()-1);
		if(final_turn.isDoubleSkunk()) {
			playerTotalScore = 0;
			return 0;
		}
			playerTotalScore += final_turn.addScore();
		return playerTotalScore;
	}

	//make current player status off and switch turn to another player
	public void switchPlayer() {
		status = false;
	}
	
	//getters
	public ArrayList<Turn> getGameTurn()
	{
		return gameTurn;
	}
	
	public int getScore() 
	{ 
		playerTotalScore = scoreUpdate();
		return playerTotalScore;
	}
		
	public int getNumOfTurn() 
	{
		return numOfTurn;
	}

	public String getName() 
	{
		return player_name;
	}
	
	public boolean turnStatus() {
		return status;	
	}

	//setters
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	//for testing
	public int scoreUpdate_test() 
	{
		if (gameTurn.size()==0) return 0;
		playerTotalScore = 0;
		Turn final_turn = gameTurn.get(gameTurn.size()-1);
		if(final_turn.isDoubleSkunk()) {
			playerTotalScore = 0;
			return 0;
		}
			playerTotalScore += final_turn.addScore_test();
		return playerTotalScore;
	}

	public void setPlayerTotalScore(int playerTotalScore)
	{
		this.playerTotalScore = playerTotalScore;
	}

}
