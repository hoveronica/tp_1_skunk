import java.util.ArrayList;
import java.util.Scanner;

public class SkunkPlayer
{
	//need to separate round list and initiates a round in the beginning. --> turn list does not work
	private String player_name;
	private ArrayList<Round> player_round;
	private Round aRound;
	private ArrayList<Turn> player_turn;
	private int turnScore;
	private int roundScore;
	private boolean status;
	private int chip;
	
	public SkunkPlayer(String name) 
	{
		this.player_name = name;
		player_round = new ArrayList<Round>();
		aRound = new Round();
		player_round.add(aRound);
		player_turn = aRound.getGameTurn();
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
	
	public Round another_round()
	{
		aRound = new Round();
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
		if(get_currentRound().get_currentTurn().isDoubleSkunk())
			roundScore = 0;
		else
			roundScore += get_currentRound().getRoundScore();
		return roundScore;
	}
	
	//getters
	public String getName() 
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
	
	public int getChip_test()
	{	
		chip = chipUpdate_test();
		return chip;
	}
	
	public int getTurnScore_test() 
	{
		if (player_turn.size()== 0) return 0;
		Turn current_turn = player_turn.get(player_turn.size()-1);
		turnScore = current_turn.getTurnScore_test();
		return turnScore;
	}
	
	public int getRoundScore_test() 
	{
		if(get_currentRound().get_currentTurn().isDoubleSkunk())
			roundScore = 0;
		else
			roundScore += get_currentRound().getRoundScore_test();
		return roundScore;
	}
	
}
