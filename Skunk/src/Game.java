import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game
{
	private ArrayList<SkunkPlayer> thePlayer;
	private SkunkPlayer current_player;
	private int current_index;
	private int kitty; 
	
	public Game(ArrayList<SkunkPlayer> players) 
	{
		this.thePlayer = players;
		current_player = new SkunkPlayer("");
		current_index = thePlayer.indexOf(current_player);
	}
	
	public void addPlayer(int playerNum) 
	{
		Scanner input = new Scanner(System.in);
		for(int x=0; x < playerNum; x++)
		{
			System.out.println("Enter your name:");
			String name = input.next();
			SkunkPlayer aPlayer = new SkunkPlayer(name);
			thePlayer.add(aPlayer);
		}
		current_player = thePlayer.get(0);
		current_player.setStatus(true);
	}
	
	public ArrayList<SkunkPlayer> getThePlayer()
	{
		return thePlayer;
	}

	//method to add individual players
	public SkunkPlayer addPlayer(String name)
	{
		SkunkPlayer aPlayer = new SkunkPlayer(name);
		thePlayer.add(aPlayer);
		return aPlayer;
	}
	
	public Round game_round() {
		current_player = thePlayer.get(0);
		Round aRound = current_player.getRound();
		for (int i=0; i<thePlayer.size();i++) {
			
		}
		return aRound;
	}
	
	public int getCurrent_index()
	{
		return current_index;
	}

	public SkunkPlayer getCurrent_player()
	{
		return current_player;
	}

	public void setCurrent_player(SkunkPlayer current_player)
	{
		this.current_player = current_player;
	}

	//compare all players and get winning player's name + score
	public SkunkPlayer winner() 
	{
		SkunkPlayer winner = current_player;
		int winning_score = current_player.getRoundScore();
		for(int x = 0; x < thePlayer.size(); x++)
		{
			if(thePlayer.get(x).getRoundScore()>winning_score)
			{
				winning_score = thePlayer.get(x).getRoundScore();
				winner = thePlayer.get(x);
				winner.setWinningStatus(true);
			}
		}
		return winner;
	}
	
	public int winning_score() 
	{
		SkunkPlayer winner = winner();
		return winner.getRoundScore();
	}

	//first set current player's status as false, set the next player in the list as current player and set his status as true
	//it wraps around after the last player
	public SkunkPlayer switchPlayer() 
	{
		if(current_index + 1 == thePlayer.size()) {
			current_player.setStatus(false); 
			current_index = 0;
			current_player = thePlayer.get(current_index);
			current_player.setStatus(true);
		}else {
			current_player.setStatus(false);
			current_index++;
			current_player = thePlayer.get(current_index);
			current_player.setStatus(true);
		}	
		return current_player;
	}
	
	public void score_report() {
		for(int i=0; i<thePlayer.size(); i++) {
			System.out.println(thePlayer.get(i).getName() + " score: " + thePlayer.get(i).getRoundScore());
		}
		System.out.println("The winner is: " + winner().getName() + ", with " + winning_score() + " points!");
		System.out.println("==========================================================");

	}
	
	//check how many points each player has and end game if one player reached 100
	public void check_points() 
	{
		int point = winning_score();
		if(point>=100) 
		{
			System.out.println(winner().getName() + " has " + winning_score() + " points! ");
			//winner rolls again or pass to loser?
		}
	}
	
	public void one_round() 
	{
		setCurrent_player(thePlayer.get(0));
		Round one_round = current_player.another_round();
		boolean game = true;
		//active player is first one on list after addPlayer method
		SkunkPlayer nextPlayer = thePlayer.get(current_index + 1);
		Scanner input = new Scanner(System.in);

		while(game) {
			System.out.println(current_player.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			int to_roll = input.nextInt();
			while(to_roll==1) {
				Roll aRoll = one_round.createTurn().createRoll();
				if(aRoll.checkDoubleSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					to_roll=2;
					current_player = nextPlayer;
				}else if(aRoll.checkSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					to_roll=2;
					current_player = nextPlayer;
				}else {
					System.out.println("You rolled: " + aRoll.toString());
					System.out.println("Do you want to roll again?");
					to_roll = input.nextInt();
					if(to_roll==2) {
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else
							current_player = nextPlayer;
					}
				}
			}
		}
		score_report();
	}
		
}
	


