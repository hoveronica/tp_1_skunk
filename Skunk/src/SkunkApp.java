import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SkunkApp 
{

	public static void main(String[] args)
	{
		ArrayList<SkunkPlayer> playerList = new ArrayList<SkunkPlayer>();
		int to_roll;
		Game aGame = new Game(playerList);
		playerList = aGame.getThePlayer();
		int num_of_player;
	
		//initiates scanner object
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Skunk game!");
		
		System.out.println("Do you want to read the instructions of the game? [Y/N]");
		String read = input.next();
		while(!read.equalsIgnoreCase("y") && !read.equalsIgnoreCase("n")){
			System.out.println("Incorrect input! Please enter [Y/N].");
			read = input.next();
		}
		if(read.equalsIgnoreCase("y")) {
			System.out.println("INSTRUCTIONS.");
			System.out.println("Game on!");
		}
		else if (read.equalsIgnoreCase("n"))
			System.out.println("Game on!");
		
		//create players
		try {
			System.out.println("How many players are there in this game?");
		num_of_player = input.nextInt();
		while (num_of_player <= 1) {
			System.out.println("Number of players must be greater than 1");
			System.out.println("How many players are there in this game?");
			num_of_player = input.nextInt();
		}
			
		}catch(InputMismatchException ex) {
			System.out.println("You must put in a number! How many players are there in this game?");
			num_of_player = input.nextInt();
		}
		aGame.addPlayer(num_of_player);
		System.out.println("Let's get rolling!");
		
		//check all players' current score, if less than 100, game rolls. This is logic of 1 round
		for(int i=0;i<num_of_player-1;i++) {
			while(playerList.get(i).getRoundScore()<=100) {				
				aGame.one_round();
			}
		}

		
		
		
		
		
		
		/* logic for two players
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
		List<Integer> p1_score = new ArrayList<Integer>();
		List<Integer> p2_score = new ArrayList<Integer>();
		int p1_total_score = 0;
		int p2_total_score = 0;
	
		
		System.out.println("Let's get rolling!");
		p1.setStatus(true);
		
		while(p1.getRoundScore()<=100 && p2.getRoundScore()<=100) 
		{
			Turn p1_turn = new Turn();
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
			System.out.println("Player 1 current score: " + p1.getRoundScore());
				
			Turn p2_turn = new Turn();
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
					p2_roll = input.nextInt();
					if(p2_roll==2) {
						break;
					}
				}
			}
			System.out.println("Player 2 current score: " + p2.getRoundScore());
	
			//final turn score of both player
			System.out.println("======================= SCOREBOARD =======================");
			System.out.println("Player 1 current score: " + p1.getRoundScore() + ". Player 2 current score: " + p2.getRoundScore());
			System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
			System.out.println("==========================================================");
			}
		
		if(p1.getRoundScore()>=100) {
			System.out.println(p2.getName() + ", you have one final turn. Do you want to make a roll?");
			p2_roll = input.nextInt();
			while(p2_roll==1) {
				Roll lastRoll = new Roll(new Dice(new RandomDie(), new RandomDie()));
				System.out.println("last roll result: " + lastRoll.toString() + ". Total of: " + lastRoll.getResult());
				if(lastRoll.checkDoubleSkunk()==true) {
					p2_total_score = 0;
					System.out.println(p1.getName() + " wins! Final score for " + p1.getName() + " is " + p1.getRoundScore());
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("Player 1 current score: " + p1.getRoundScore() + ". Player 2 current score: " + p2_total_score);
					System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
					System.out.println("Winner is: " + p1.getName()+ ". Congratulations!");
					System.out.println("==========================================================");
					p2_roll = 2;
					break;
				}else if(lastRoll.checkSkunk()==true) {
					p2_total_score = p2.getRoundScore();
					System.out.println(p1.getName() + " wins! Final score for " + p1.getName() + " is " + p1.getRoundScore());
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("Player 1 current score: " + p1.getRoundScore() + ". Player 2 current score: " + p2_total_score);
					System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
					System.out.println("Winner is: " + p1.getName()+ ". Congratulations!");
					System.out.println("==========================================================");
					p2_roll = 2;
					break;
				}else {
					p2_total_score = p2.getRoundScore() + lastRoll.getResult();
				}
				System.out.println("Do you want to roll again?");
				p2_roll = input.nextInt();
				if(p2_roll==2) {
					if(p2_total_score>=p1.getRoundScore()) {
						System.out.println(p2.getName() + " wins! Final score for " + p2.getName() + " is " + p2_total_score);
						System.out.println("======================= SCOREBOARD =======================");
						System.out.println("Player 1 current score: " + p1.getRoundScore() + ". Player 2 current score: " + p2_total_score);
						System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
						System.out.println("Winner is: " + p2.getName()+ ". Congratulations!");
						System.out.println("==========================================================");
					}else {
						System.out.println(p1.getName() + " wins! Final score for " + p1.getName() + " is " + p1.getRoundScore());
						System.out.println("======================= SCOREBOARD =======================");
						System.out.println("Player 1 current score: " + p1.getRoundScore() + ". Player 2 current score: " + p2_total_score);
						System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
						System.out.println("Winner is: " + p1.getName()+ ". Congratulations!");
						System.out.println("==========================================================");
					}
				}
			}
		}else if(p2.getRoundScore()>=100) {
			System.out.println(p1.getName() + ", you have one final turn. Do you want to make a roll?");
			p1_roll = input.nextInt();
			while(p1_roll==1) {
				Roll lastRoll = new Roll(new Dice(new RandomDie(), new RandomDie()));
				System.out.println("last roll result: " + lastRoll.toString() + ". Total of: " + lastRoll.getResult());
				if(lastRoll.checkDoubleSkunk()==true) {
					p1_total_score = 0;
					System.out.println(p2.getName() + " wins! Final score for " + p2.getName() + " is " + p2.getRoundScore());
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("Player 1 current score: " + p1_total_score + ". Player 2 current score: " + p2.getRoundScore());
					System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
					System.out.println("Winner is: " + p2.getName()+ ". Congratulations!");
					System.out.println("==========================================================");
					p1_roll = 2;
					break;
				}else if(lastRoll.checkSkunk()==true) {
					p1_total_score = p1.getRoundScore();
					System.out.println(p2.getName() + " wins! Final score for " + p2.getName() + " is " + p2.getRoundScore());
					System.out.println("======================= SCOREBOARD =======================");
					System.out.println("Player 1 current score: " + p1_total_score + ". Player 2 current score: " + p2.getRoundScore());
					System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
					System.out.println("Winner is: " + p2.getName()+ ". Congratulations!");
					System.out.println("==========================================================");
					p1_roll = 2;
					break;
				}else {
					p1_total_score = p1.getRoundScore() + lastRoll.getResult();
				}
				System.out.println("Do you want to roll again?");
				p1_roll = input.nextInt();
				if(p1_roll==2) {
					if(p1_total_score>=p2.getRoundScore()) {
						System.out.println(p1.getName() + " wins! Final score for " + p1.getName() + " is " + p1_total_score);
						System.out.println("======================= SCOREBOARD =======================");
						System.out.println("Player 1 current score: " + p1_total_score + ". Player 2 current score: " + p2.getRoundScore());
						System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
						System.out.println("Winner is: " + p1.getName()+ ". Congratulations!");
						System.out.println("==========================================================");
					}else {
						System.out.println(p2.getName() + " wins! Final score for " + p2.getName() + " is " + p2.getRoundScore());
						System.out.println("======================= SCOREBOARD =======================");
						System.out.println("Player 1 current score: " + p1_total_score + ". Player 2 current score: " + p2.getRoundScore());
						System.out.println("Player 1 chip: " + p1.getChip() + ". Player 2 chip: " + p2.getChip());
						System.out.println("Winner is: " + p2.getName()+ ". Congratulations!");
						System.out.println("==========================================================");
					}
				}
			}
		}*/
	
	}
}

