//in game class, track players

public class SkunkPlayer
{
	private String player_name;
	private int playerTotalScore;
	private Turn gameTurn;
	
	public SkunkPlayer(String name) {
		this.player_name = name;
		gameTurn = new Turn();
		playerTotalScore = 0;
	}
	
	public String getName() {
		return player_name;
	}

	//update score after turn
	public int scoreUpdate() {
		playerTotalScore = playerTotalScore + gameTurn.getTurnScore();
		return playerTotalScore;
	}
	
	//getter for playerScore
	public int getScore() { 
		return playerTotalScore;
	}
}


