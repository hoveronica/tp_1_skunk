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
	private Turn aTurn;
	private int numOfPlayer;
	
	public Game(ArrayList<SkunkPlayer> playerList) 
	{
		this.thePlayer = playerList;
		current_player = new SkunkPlayer("");
		current_index = thePlayer.indexOf(current_player);
		aTurn = new Turn();
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
		Scanner input = new Scanner(System.in);
		
		SkunkPlayer player1 = thePlayer.get(0);
		SkunkPlayer player2 = thePlayer.get(1);
		
		int to_roll_p1;
		int to_roll_p2;
		
		List<Turn> p1_list = new ArrayList<Turn>();
		List<Turn> p2_list = new ArrayList<Turn>();
		
		while(player1.getScore()!=100 || player2.getScore()!=100) {
			Round aRound = new Round();
			player1.setStatus(true);
			System.out.println(player1.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll_p1 = input.nextInt();
			Turn p1_Turn = player1.createTurn();
			p1_list.add(p1_Turn);
			
			while(to_roll_p1==1) 
			{
				Roll aRoll = p1_Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					System.out.println("You lost all your points!");
					//check_points();
					//need to store this turn into a round
					
					to_roll_p1 = 2;
					to_roll_p2 = 1;
					
					
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					System.out.println("You lost all your points from this turn.");
					//check_points();
					to_roll_p1 = 2;
					to_roll_p2 = 1;
					
				}else
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
					//check_points();
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll_p1 = input.nextInt();
					if(to_roll_p1==2) 
					{
						to_roll_p2=1;
					}
				}
			}
			
			player1.setStatus(false);
			player2.setStatus(true);
			
			System.out.println(player2.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll_p2 = input.nextInt();
			Turn p2_Turn = player1.createTurn();
			p2_list.add(p2_Turn);
			
			while(to_roll_p2==1) 
			{
				Roll aRoll = p2_Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					System.out.println("You lost all your points!");
					//check_points();
					//need to store this turn into a round
					to_roll_p2 = 2;
					to_roll_p1 = 1;
					
					
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					System.out.println("You lost all your points from this turn.");
					//check_points();
					to_roll_p2 = 2;
					to_roll_p1 = 1;
					
				}else
				{
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
					//check_points();
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll_p2 = input.nextInt();
					if(to_roll_p2==2) 
					{
						to_roll_p1=1;
					}
				}
			}
			
			//round end
			int p1_score = player1.getScore();
			int p2_score = player2.getScore();
			List<Integer> p1_total = new ArrayList<Integer>();
			List<Integer> p2_total = new ArrayList<Integer>();
			p1_total.add(p1_score);
			p2_total.add(p2_score);
			
			System.out.println("Score update:");
			System.out.println("Player1: " + p1_score + ". Player2: " + p2_score );
			
		}
	}
	
		
	public void game_control(SkunkPlayer aPlayer) 
	{
		aPlayer = current_player;
		
		SkunkPlayer nextPlayer = new SkunkPlayer("");
		Scanner input = new Scanner(System.in);

		System.out.println(aPlayer.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
		int to_roll = input.nextInt();
		
		//whenever it passes, it creates a new Turn such that the score never adds up
		//where to put the createTurn?
		aTurn = aPlayer.createTurn(); 
		
					
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
				//round_score.put(aPlayer,current_player_turn);
				score_report();
				to_roll=2;
				nextPlayer = switchPlayer();
				game_control(nextPlayer);
				
			}else
			{
				System.out.println("======================= SCOREBOARD =======================");
				System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
				//round_score.put(aPlayer,current_player_turn);
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

