import java.util.ArrayList;

public class Round
{
	private Turn game_turn;
	private int numOfTurn;
	private ArrayList<Turn> turn_list;
	private int Round_Score;

	public Round() {
		game_turn = new Turn();
		numOfTurn = 0;
		this.turn_list = new ArrayList<Turn>();
		Round_Score = 0;
	}
	
	public Turn createTurn() 
	{
		Turn aTurn = new Turn();
		numOfTurn++;
		turn_list.add(aTurn);
		return aTurn;
	}
		
	public void update_Score() {
		for(int x=0 ; x < turn_list.size() ; x++) 
		{
			Round_Score += turn_list.get(x).getTurnScore();
		}
	}
	
	public int getRound_Score() {
		update_Score();
		return Round_Score;
	}
}
