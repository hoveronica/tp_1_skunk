import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class stores each player's Turn scores
 */

public class Round
{
	SkunkPlayer p1;
	SkunkPlayer p2;
	int p1_total;
	int p2_total;
	
	public Round() {
		p1 = new SkunkPlayer("");
		p2 = new SkunkPlayer("");
		p1_total = p1.getScore();
		p2_total = p2.getScore();
	}

	public int getP1_total()
	{
		return p1_total;
	}

	public int getP2_total()
	{
		return p2_total;
	}

	
	
	
}
