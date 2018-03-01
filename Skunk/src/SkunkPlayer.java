//in game class, track players




public class SkunkPlayer
{
	private String player_name;
	private int score;
	private int playerTotalScore;
	
	public SkunkPlayer(String name) {
		this.player_name = name;
	}

	public int playerScore() {  //keeps track of players total score 
		return playerTotalScore;
	}
	//come from end of roll
	public int scoreUpdate() {
		score = playerTotalScore + Turn.turnScore;
		return score;
	}
}


