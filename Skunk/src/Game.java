import java.util.ArrayList;

public class Game
{
	private ArrayList<SkunkPlayer> thePlayer;
	private int numOfPlayer;
	
	public Game() 
	{
		thePlayer = new ArrayList<SkunkPlayer>(100);
		numOfPlayer = 2;
	}
	
	public void addPlayer(String name) 
	{
		SkunkPlayer aPlayer = new SkunkPlayer(name);
		thePlayer.add(aPlayer);
		numOfPlayer++;
	}
	
	//compare all players and get winning player's name + score
	public String winningPlayer() 
	{
		SkunkPlayer winner = new SkunkPlayer("");
		int winning_score = 0;
		for(int x = 0; x < thePlayer.size()-1; x++)
		{
			if(thePlayer.get(x).getScore()>winning_score)
			{
				winner = thePlayer.get(x);
			}
		}
		return "The winner is: " + winner.getName() + ", with " + winner.getScore() + " points!";
	}
	
	public int getNumOfPlayer() 
	{
		return numOfPlayer;
	}
}
