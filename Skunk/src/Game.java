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
	private Round aRound;
	private int numOfPlayer;
	
	public Game(ArrayList<SkunkPlayer> playerList) 
	{
		this.thePlayer = playerList;
		current_player = new SkunkPlayer("");
		current_index = thePlayer.indexOf(current_player);
		aRound = new Round();
		numOfPlayer = 0;
	}
	
	public void addPlayer(int playerNum) 
	{
		Scanner input = new Scanner(System.in);
		for(int x=0;x<playerNum;x++)
		{
			System.out.println("Enter your name:");
			String name = input.next();
			SkunkPlayer aPlayer = new SkunkPlayer(name);
			thePlayer.add(aPlayer);
			numOfPlayer++;
		}
		current_player = thePlayer.get(0);
		current_player.setStatus(true);
		current_index++;
	}
	
	//method to add individual players
	public SkunkPlayer addPlayer(String name)
	{
		SkunkPlayer aPlayer = new SkunkPlayer(name);
		thePlayer.add(aPlayer);
		numOfPlayer++;
		return aPlayer;
	}
	
	public Round createRound() 
	{
		
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

	//compare all players and get winning player's name + score
	public SkunkPlayer winningPlayer() 
	{
		SkunkPlayer winner = current_player;
		int winning_score = current_player.getScore();
		for(int x = 0; x < thePlayer.size(); x++)
		{
			if(thePlayer.get(x).getScore()>winning_score)
			{
				winning_score = thePlayer.get(x).getScore();
				winner = thePlayer.get(x);
			}
		}
		return winner;
	}
	
	public int winning_score() 
	{
		SkunkPlayer winner = winningPlayer();
		return winner.getScore();
	}
	
	public int getNumOfPlayer() 
	{
		return numOfPlayer;
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
		//print each player's score
		//System.out.printf();
		System.out.println("Player1 score: " + thePlayer.get(0).getScore() + ". Player2 score: " + thePlayer.get(1).getScore());
		System.out.println("The winner is: " + winningPlayer().getName() + ", with " + winning_score() + " points!");
		System.out.println("==========================================================");

	}
	
	//check how many points each player has and end game if one player reached 100
	public void check_points() 
	{
		int point = winning_score();
		if(point>=100) 
		{
			System.out.println(winningPlayer().getName() + " has " + winning_score() + " points! ");
			//winner rolls again or pass to loser?
		}
	}
	
	public void game_for_2() 
	{
		SkunkPlayer player1 = thePlayer.get(0);
		SkunkPlayer player2 = thePlayer.get(1);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(player1.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
		int to_roll = input.nextInt();
		
	}
	
	
		
	public void game_control(SkunkPlayer aPlayer) 
	{
		aPlayer = current_player;
		SkunkPlayer nextPlayer = new SkunkPlayer("");
		ArrayList<Turn> current_player_turn = aPlayer.getGameTurn();
		Map<SkunkPlayer, ArrayList<Turn>> round_score = aRound.getScoreboard();

		Scanner input = new Scanner(System.in);

		System.out.println(aPlayer.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
		int to_roll = input.nextInt();
		
		//whenever it passes, it creates a new Turn such that the score never adds up
		//where to put the createTurn?
		Turn aTurn = current_player.createTurn(); 
		current_player_turn.add(aTurn);
					
		if(to_roll==2) 
		{
			nextPlayer = switchPlayer();
			game_control(nextPlayer);
		}
			
		while(to_roll==1) 
		{
			Roll aRoll = aTurn.createRoll();
			if(aRoll.checkDoubleSkunk()==true) 
			{
				System.out.println("======================= SCOREBOARD =======================");
				System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
				System.out.println("You lost all your points!");
				//check_points();
				//need to store this turn into a round
				score_report();
				to_roll = 2;
				nextPlayer = switchPlayer();
				game_control(nextPlayer);
				
			}else if(aRoll.checkSkunk()==true)
			{
				System.out.println("======================= SCOREBOARD =======================");
				System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
				System.out.println("You lost all your points from this turn.");
				//check_points();
				round_score.put(aPlayer,current_player_turn);
				score_report();
				to_roll=2;
				nextPlayer = switchPlayer();
				game_control(nextPlayer);
				
			}else
			{
				System.out.println("======================= SCOREBOARD =======================");
				System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
				round_score.put(aPlayer,current_player_turn);
				score_report();
				//check_points();
				
				System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
				to_roll = input.nextInt();
				if(to_roll==2) 
				{
					nextPlayer = switchPlayer();
					game_control(nextPlayer);
				}
			}
		}
	}
	
	

	
}

