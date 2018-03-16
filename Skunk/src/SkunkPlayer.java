import java.util.ArrayList;
import java.util.Scanner;

public class SkunkPlayer
{
	private String player_name;
	private Round player_round;
	private ArrayList<Turn> player_turn;
	private int turnScore;
	private int roundScore;
	private boolean status;
	private boolean winner;
	private int chip;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		player_round = new Round();
		player_turn = player_round.getGameTurn();
		chip = 50;
	}
	
	public int getTurnScore() 
	{
		return turnScore;
	}
	
	public int getRoundScore() 
	{
		return roundScore;
	}
	
	public int chipUpdate() {
		if(player_turn.size()==0) return 50;
		Turn final_turn = player_turn.get(player_turn.size()-1);
		Roll theRoll = final_turn.getLastRoll();
		if(theRoll.checkDoubleSkunk()==true) 
			chip = chip - 4;
		else if(theRoll.checkDeuce()==true)
			chip = chip - 2;
		else if(theRoll.checkSkunk()==true) 
			chip = chip - 1;
		return chip;
	}
	
	//getters
	public String getName() 
	{
		return player_name;
	}

	public String getPlayer_name()
	{
		return player_name;
	}

	public Round getRound()
	{
		return player_round;
	}

	public ArrayList<Turn> getPlayer_turn()
	{
		return player_turn;
	}

	public boolean gameStatus()
	{
		return status;
	}

	public void setTurnScore(int turnScore)
	{
		this.turnScore = turnScore;
	}

	public void setRoundScore(int roundScore)
	{
		this.roundScore = roundScore;
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
	
	public void setWinningStatus(boolean winner) 
	{
		this.winner = winner;
	}
	
	public int chipUpdate_test() {
		if(player_turn.size()==0) return 50;
		Turn final_turn = player_turn.get(player_turn.size()-1);
		Roll theRoll = final_turn.getLastRoll();
		if(theRoll.checkDoubleSkunk_test()==true) 
			chip = chip - 4;
		else if(theRoll.checkDeuce_test()==true)
			chip = chip - 2;
		else if(theRoll.checkSkunk_test()==true) 
			chip = chip - 1;
		return chip;
	}
}
