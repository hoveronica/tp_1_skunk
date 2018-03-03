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
	static int to_roll = input.nextInt();
	
	
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
		boolean player1Status = playerList.get(0).turnStatus();
		boolean player2Status = playerList.get(1).turnStatus();
		player1Status = true;
		player2Status = false;
		int player1Score = 0;
		int player2Score = 0;
		
		if(player1Status==true) 
		{
			System.out.println(player1.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn aTurn = new Turn();
			
			if(to_roll==2) 
			{
				switchPlayer();
				player1Status=false;
				player2Status=true;
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = aTurn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled a double skunk.");
					player1Roll.add(aRoll);
					break;
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled a skunk.");
					player1Roll.add(aRoll);
					break;
				}else
				{
					System.out.println("You rolled a " + aRoll.getResult());
					player1Roll.add(aRoll);
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			} 
			
		}else if(player2Status==true)
		{
			System.out.println(player1.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn aTurn = new Turn();
			
			if(to_roll==2) 
			{
				switchPlayer();
				player1Status=false;
				player2Status=true;
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = aTurn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled a double skunk.");
					player1Roll.add(aRoll);
					break;
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled a skunk.");
					player1Roll.add(aRoll);
					break;
				}else
				{
					System.out.println("You rolled a " + aRoll.getResult());
					player1Roll.add(aRoll);
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			} 
		}
		
		
		
		System.out.println(playerList.get(0).getName() + " scores " + player1.scoreUpdate() + " and " + playerList.get(1).getName() + " scores " + player2.scoreUpdate());
			
		}
	
	private static SkunkPlayer switchPlayer() 
	{
		SkunkPlayer currentPlayer = playerList.get(0);
		if(to_roll==2) 
		{
			currentPlayer = playerList.get(1);
		}
		return currentPlayer;
	}

	}

