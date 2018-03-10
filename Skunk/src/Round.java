import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class stores each player's Turn scores
 */

public class Round
{
	Map<SkunkPlayer, ArrayList<Turn>> scoreboard;
	List<SkunkPlayer> players;
	
	public Round() {
		scoreboard = new HashMap<SkunkPlayer,ArrayList<Turn>>();
		players = new ArrayList<SkunkPlayer>();
	}

	public void store_the_round()
	{			
		for(int i=0; i<players.size(); i++)
		{
			scoreboard.put(players.get(i), players.get(i).getGameTurn());
		}
	}
	
	public Map<SkunkPlayer, ArrayList<Turn>> getScoreboard()
	{
		return scoreboard;
	}

	
}
