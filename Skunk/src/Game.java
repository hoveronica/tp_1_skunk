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
	
	public int getCurrent_index()
	{
		return current_index;
	}

	public void setCurrent_index(int current_index)
	{
		this.current_index = current_index;
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
			}
		}
		return winner;
	}
	
	public int winning_score()
	{
		int score = 0;
		score = winner().getRoundScore();
		return score;
	}
	
	public void score_report() {
		System.out.println("======================= SCOREBOARD =======================");
		for(int i=0; i<thePlayer.size(); i++) {
			System.out.println(thePlayer.get(i).getName() + "'s current score: " + thePlayer.get(i).getRoundScore()
					+ ". Chip count: " + thePlayer.get(i).getChip());
		}
		System.out.println("Kitty has " + kitty + " chips.");
		System.out.println("==========================================================");

	}
	
	public void end_report() {
		System.out.println("======================= SCOREBOARD =======================");
		for(int i=0; i<thePlayer.size(); i++) {
			System.out.println(thePlayer.get(i).getName() + "'s current score: " + thePlayer.get(i).getRoundScore()
					+ ". Chip count: " + thePlayer.get(i).getChip());
		}
		System.out.println("Winner is: " + winner().getName() + " with " + winning_score()+ " points. ");
		System.out.println("New chip count: ");
		for(int i=0; i<thePlayer.size(); i++) {
			System.out.println(thePlayer.get(i).getName()+ "'s chip count: " + thePlayer.get(i).getChip());
		}
		System.out.println("==========================================================");
	}
	
	public boolean check_score() 
	{
		for(int i=0;i<thePlayer.size();i++) {
			if(thePlayer.get(i).getRoundScore()>=100) return true;
		}
		return false;
	}
	
	public void first_round() 
	{
		setCurrent_player(thePlayer.get(0));
		setCurrent_index(0);
		boolean game = true;
		
		//active player is first one on list after addPlayer method
		SkunkPlayer nextPlayer = thePlayer.get(current_index + 1);
		Scanner input = new Scanner(System.in);

		while(game) {
			System.out.println(current_player.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			int to_roll = input.nextInt();
			Roll aRoll = current_player.get_currentRound().createTurn().createRoll();
			while(to_roll==1) {
				if(aRoll.checkDoubleSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					to_roll=2;
					kitty=+4;
					if(current_index==thePlayer.size()-1) {
						game=false;
					}else {
						current_player = nextPlayer;
						current_index++;
						nextPlayer = thePlayer.get(current_index);
					}
				}else if(aRoll.checkSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					to_roll=2;
					if(aRoll.checkDeuce()==true) 
						kitty+=2;
						else kitty++;
					if(current_index==thePlayer.size()-1) {
						game=false;
					}else {
						current_player = nextPlayer;
						current_index++;
						nextPlayer = thePlayer.get(current_index);
					}
				}else {
					System.out.println("You rolled: " + aRoll.toString());
					System.out.println("Do you want to roll again?");
					to_roll = input.nextInt();
					if(to_roll==1) {
						aRoll = current_player.get_currentRound().get_currentTurn().createRoll();
					}else if(to_roll==2) {
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}
				}
			}
		}
		score_report();
	}
	
	public void one_round() 
	{
		setCurrent_player(thePlayer.get(0));
		setCurrent_index(0);
		boolean game = true;
		
		//active player is first one on list after addPlayer method
		SkunkPlayer nextPlayer = thePlayer.get(current_index + 1);
		Scanner input = new Scanner(System.in);

		while(game) {
			System.out.println(current_player.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			int to_roll = input.nextInt();
			Roll aRoll = current_player.another_round().createTurn().createRoll();
			if(to_roll==2) {
				
			}
			while(to_roll==1) {
				if(aRoll.checkDoubleSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					to_roll=2;
					kitty=+4;
					if(current_index==thePlayer.size()-1) {
						game=false;
					}else {
						current_player = nextPlayer;
						current_index++;
						nextPlayer = thePlayer.get(current_index);
					}
				}else if(aRoll.checkSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					to_roll=2;
					if(aRoll.checkDeuce()==true) 
						kitty+=2;
						else kitty++;
					if(current_index==thePlayer.size()-1) {
						game=false;
					}else {
						current_player = nextPlayer;
						current_index++;
						nextPlayer = thePlayer.get(current_index);
					}
				}else {
					System.out.println("You rolled: " + aRoll.toString());
					System.out.println("Do you want to roll again?");
					to_roll = input.nextInt();
					if(to_roll==1) {
						aRoll = current_player.get_currentRound().get_currentTurn().createRoll();
					}else if(to_roll==2) {
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}
				}
			}
		}
		score_report();
	}
	
	public void last_round() {
		Scanner input = new Scanner(System.in);
		SkunkPlayer winner = winner();
		boolean game = true;
		if(winner!=thePlayer.get(0)) {
			current_player = thePlayer.get(0);
			setCurrent_index(0);
			SkunkPlayer nextPlayer = thePlayer.get(current_index + 1);
			while(game) {
				System.out.println("This is the final round!");
				System.out.println(current_player.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
				int to_roll = input.nextInt();
				Roll aRoll = current_player.get_currentRound().createTurn().createRoll();
				while(to_roll==1) {
					if(aRoll.checkDoubleSkunk()==true) {
						System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
						to_roll=2;
						kitty=+4;
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}else if(aRoll.checkSkunk()==true) {
						System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
						to_roll=2;
						if(aRoll.checkDeuce()==true) 
							kitty+=2;
							else kitty++;
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}else {
						System.out.println("You rolled: " + aRoll.toString());
						System.out.println("Do you want to roll again?");
						to_roll = input.nextInt();
						if(to_roll==1) {
							aRoll = current_player.get_currentRound().get_currentTurn().createRoll();
						}else if(to_roll==2) {
							if(current_index==thePlayer.size()-1) {
								game=false;
							}else {
								current_player = nextPlayer;
								current_index++;
								nextPlayer = thePlayer.get(current_index);
							}
						}
					}
				}
			}
		}else {
			current_player = thePlayer.get(1);
			setCurrent_index(1);
			SkunkPlayer nextPlayer = thePlayer.get(0);
			while(game) {
				System.out.println(current_player.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
				int to_roll = input.nextInt();
				Roll aRoll = current_player.get_currentRound().createTurn().createRoll();
				while(to_roll==1) {
					if(aRoll.checkDoubleSkunk()==true) {
						System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
						to_roll=2;
						kitty+=4;
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}else if(aRoll.checkSkunk()==true) {
						System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
						to_roll=2;
						if(aRoll.checkDeuce()==true) 
							kitty+=2;
							else kitty++;
						if(current_index==thePlayer.size()-1) {
							game=false;
						}else {
							current_player = nextPlayer;
							current_index++;
							nextPlayer = thePlayer.get(current_index);
						}
					}else {
						System.out.println("You rolled: " + aRoll.toString());
						System.out.println("Do you want to roll again?");
						to_roll = input.nextInt();
						if(to_roll==1) {
							aRoll = current_player.get_currentRound().get_currentTurn().createRoll();
						}else if(to_roll==2) {
							if(current_index==thePlayer.size()-1) {
								game=false;
							}else {
								current_player = nextPlayer;
								current_index++;
								nextPlayer = thePlayer.get(current_index);
							}
						}
					}
				}
			}
		}
		score_report();
		System.out.println("Kitty has " + kitty + " chips! " + winner.getName()+ " gets all the chips.");
		System.out.println("Game ends!");
	}
		
}
