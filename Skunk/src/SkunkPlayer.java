import java.util.ArrayList;
import java.util.Scanner;

public class SkunkPlayer
{
	private String player_name;
	private ArrayList<Turn> player_turn;
	private ArrayList<Round> player_round;
	private int turnScore;
	private int roundScore;
	private boolean status;
	private boolean winner;
	private int chip;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		player_turn = new ArrayList<Turn>();
		player_round = new ArrayList<Round>();
		chip = 50;
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
		//playerTotalScore = 0;
		Turn final_turn = gameTurn.get(gameTurn.size()-1);
		if(final_turn.isDoubleSkunk()) {
			playerTotalScore = 0;
			return 0;
		}else if(final_turn.isSingleSkunk()) {
		}
			playerTotalScore += final_turn.addScore();
		return playerTotalScore;
	}
	
	public int chipUpdate() {
		if(gameTurn.size()==0) return 50;
		Turn final_turn = gameTurn.get(gameTurn.size()-1);
		Roll theRoll = final_turn.getLastRoll();
		if(theRoll.checkDoubleSkunk()==true) 
			chip = chip-4;
		else if(theRoll.checkSkunk()==true) 
			chip = chip-1;
		return chip;
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

	public int getChip()
	{	
		chip = chipUpdate();
		return chip;
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
		//playerTotalScore = 0;
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
