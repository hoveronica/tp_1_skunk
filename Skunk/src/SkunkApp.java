import java.util.ArrayList;
import java.util.Scanner;

public class SkunkApp 
{
	//initiates scanner object
	static Scanner input = new Scanner(System.in);

	//create attributes
	static ArrayList<SkunkPlayer> playerList = new ArrayList<SkunkPlayer>(100);
	static ArrayList<Roll> player1Roll = new ArrayList<Roll>(50);
	static ArrayList<Roll> player2Roll = new ArrayList<Roll>(50);
	static Game aGame = new Game();
	static int to_roll;
	static boolean player1Status;
	static boolean player2Status;

	
	
	public static void main(String[] args)
	{
		
		System.out.println("Welcome to Skunk game!");
		
		//create players
		System.out.println("Player 1, what is your name?");
		String player1_name = input.next();
		SkunkPlayer player1 = new SkunkPlayer(player1_name);
		System.out.println("Player 2, what is your name?");
		String player2_name = input.next();
		SkunkPlayer player2 = new SkunkPlayer(player2_name);
		playerList.add(player1);
		playerList.add(player2);
		
		//start rolling
		System.out.println("Let's get rolling!");
		player1Status = true;
		player2Status = false;
		int player1Score = 0;
		int player2Score = 0;
		
		while(player1Status==true) 
		{
			System.out.println(player1.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn player1Turn = new Turn();
			
			if(to_roll==2) 
			{
				switchPlayer();
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = player1Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled a double skunk.");
					player1Roll.add(aRoll);
					player1Turn.addScore();
					return;
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled a skunk.");
					player1Roll.add(aRoll);
					player1Turn.addScore();

					return;
				}else
				{
					System.out.println("You rolled a " + aRoll.getResult());
					player1Roll.add(aRoll);
					player1Turn.addScore();

					System.out.println("player 1 score " + player1Turn.addScore());
					System.out.println("player 1 score - test player class" + player1.scoreUpdate());
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			}

			
		}
		while(player2Status==true)
		{
			System.out.println(player2.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn player2Turn = new Turn();
			
			if(to_roll==2) 
			{
				switchPlayer();
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = player2Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled a double skunk.");
					player2Roll.add(aRoll);
					player2Turn.addScore();

					return;
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled a skunk.");
					player2Roll.add(aRoll);
					player2Turn.addScore();

					return;
				}else
				{
					System.out.println("You rolled a " + aRoll.getResult());
					player2Roll.add(aRoll);
					player2Turn.addScore();
					
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			}

		}
		
	
		System.out.println(playerList.get(0).getName() + " scores " + player1.getScore() + " and " + playerList.get(1).getName() + " scores " + player2.getScore());
			
		}
	
	private static void switchPlayer() 
	{
		SkunkPlayer currentPlayer = playerList.get(1);
		player1Status = false;
		player2Status = true;
	}

	}

