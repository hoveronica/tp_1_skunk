import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * this class store each round of game. It has multiple players' turns' info
 */

public class Round
{
	private ArrayList<Turn> gameTurn; 
	private int roundScore;
	private int numOfTurn;
	
	public Round(ArrayList<Turn> turn_list) {
		this.gameTurn = turn_list;
		roundScore = 0;
		numOfTurn = 0;
	}
	
	public Turn one_turn()
	{
		Turn aTurn = new Turn();
		gameTurn.add(aTurn);
		numOfTurn++;
		return aTurn;
	}
	
	public int round_score() 
	{
		for(int x=0 ; x < gameTurn.size() ; x++) 
		{
			roundScore = gameTurn.get(x).addScore();
		}
		return roundScore;
	}
	
	public int getRoundScore() {
		return roundScore;
	}
	
}
