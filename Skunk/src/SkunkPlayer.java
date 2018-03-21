import java.util.ArrayList;
import java.util.Scanner;

public class SkunkPlayer
{
	private String player_name;
	private ArrayList<Round> player_round;
	private ArrayList<Turn> player_turn;
	private int turnScore;
	private int roundScore;
	private boolean status;
	private boolean winner;
	private int chip;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		player_round = new ArrayList<Round>();
		player_turn = new ArrayList<Turn>();
		chip = 50;
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
	
	//want to store up round score? not really, maybe kitty score
	public Round another_round()
	{
		Round aRound = new Round();
		player_round.add(aRound);
		return aRound;
	}
		
	public int getTurnScore() 
	{
		if (player_turn.size()== 0) return 0;
		Turn current_turn = player_turn.get(player_turn.size()-1);
		turnScore = current_turn.getTurnScore();
		return turnScore;
	}
	
	public int getRoundScore() 
	{
		for(int i=0; i<player_round.size();i++) {
			roundScore += player_round.get(i).getRoundScore();
		}
		return roundScore;
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

	public Round get_currentRound()
	{
		Round current_round = player_round.get(player_round.size()-1);
		return current_round;
	}

	public ArrayList<Turn> getPlayer_turn()
	{
		player_turn = get_currentRound().getGameTurn();
		return player_turn;
	}

	public boolean gameStatus()
	{
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
	
	public void setWinningStatus(boolean winner) 
	{
		this.winner = winner;
	}
	
	public void setTurnScore(int turnScore)
	{
		this.turnScore = turnScore;
	}

	public void setRoundScore(int roundScore)
	{
		this.roundScore = roundScore;
	}

	
	/*
	 * the following methods are for testing
	 */
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
	
	public int getTurnScore_test() 
	{
		if (player_turn.size()== 0) return 0;
		Turn current_turn = player_turn.get(player_turn.size()-1);
		turnScore = current_turn.getTurnScore_test();
		return turnScore;
	}
	
	/*public int getRoundScore_test() 
	{
		roundScore = player_round.getRoundScore_test();
		return roundScore;
	}*/
}
