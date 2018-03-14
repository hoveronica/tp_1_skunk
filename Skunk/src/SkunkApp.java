import java.util.ArrayList;
import java.util.Scanner;

public class SkunkApp 
{

	public static void main(String[] args)
	{
		//initiates scanner object
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Skunk game!");
		
		//create players
		System.out.println("Please select 2 players for this game.");
		System.out.println("Player 1, please enter your name:");
		String p1_name = input.next();
		System.out.println("Player 2, please enter your name:");
		String p2_name = input.next();
		SkunkPlayer p1 = new SkunkPlayer(p1_name);
		SkunkPlayer p2 = new SkunkPlayer(p2_name);
		int p1_roll;
		int p2_roll;
		
		System.out.println("Let's get rolling!");
		p1.setStatus(true);
		
		while(p1.getScore()!=100 && p2.getScore()!=100) 
		{
			Turn p1_turn = p1.createTurn();
			System.out.println(p1.getName() + ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			p1_roll = input.nextInt();
			
			while(p1_roll==1) {
				Roll aRoll = p1_turn.createRoll();
				p1_turn.addScore();
				if(aRoll.checkDoubleSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					p1_roll=2;
				}else if(aRoll.checkSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					p1_roll=2;
				}else {
					System.out.println("You rolled: " + aRoll.toString());
					System.out.println("Do you want to roll again?");
					p1_roll = input.nextInt();
					if(p1_roll==2) {
						break;
					}
				}
			}
			System.out.println("Player 1 current score: " + p1.getScore());
			
			Turn p2_turn = p2.createTurn();
			System.out.println(p2.getName() + ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			p2_roll = input.nextInt();
			
			while(p2_roll==1) {
				Roll aRoll = p2_turn.createRoll();
				p2_turn.addScore();
				if(aRoll.checkDoubleSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					p2_roll=2;
				}else if(aRoll.checkSkunk()==true) {
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					p2_roll=2;
				}else {
					System.out.println("You rolled: " + aRoll.toString());
					System.out.println("Do you want to roll again?");
					p1_roll = input.nextInt();
					if(p2_roll==2) {
						break;
					}
				}
			}
			System.out.println("Player 2 current score: " + p2.getScore());
			
			//final turn score of both player
			System.out.println("======================= SCOREBOARD =======================");
			System.out.println("Player 1 turn score: " + p1.getScore() + ". Player 2 turn score: " + p2.getScore());
			System.out.println("==========================================================");
			}

	}
		
		
		
		/* will come back to this logic for final implementation
		 * 
		//create attributes
		ArrayList<SkunkPlayer> playerList = new ArrayList<SkunkPlayer>();
		ArrayList<Round> roundList = new ArrayList<Round>();
		int to_roll;
		Game aGame = new Game(playerList);
			
		System.out.println("Welcome to Skunk game!");
	
		//create players
		System.out.println("How many players are there in this game?");
		int num_of_player = input.nextInt();
		while (num_of_player <= 1) {
			System.out.println("Number of players must be greater than 1");
			System.out.println("How many players are there in this game?");
			num_of_player = input.nextInt();
		}
		aGame.addPlayer(num_of_player);
		SkunkPlayer active_player = aGame.getCurrent_player();
			
		//start rolling
		System.out.println("Let's get rolling!");
		
		//aGame.game_for_2();
		
		while(active_player.turnStatus()==true) 
		{
			aGame.game_control(active_player);
		}
		System.out.println(playerList.get(0).getName() + " scores " + playerList.get(0).getScore() + " and " + playerList.get(1).getName() + " scores " + playerList.get(1).getScore());
		*/
		
		
		
		
		}
