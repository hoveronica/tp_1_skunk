//in game class, track players


public class SkunkPlayer
{
	private String player_name;
	private int score;
	
	public SkunkPlayer(String name) {
		this.player_name = name;
	}

	//come from end of roll
	public int scoreUpdate() {
		return score;
	}
}


