import java.util.ArrayList;
import java.util.Scanner;

public class SkunkApp 
{
	
	public static void main(String[] args)
	{
		//create attributes
		ArrayList<SkunkPlayer> playerList = new ArrayList<SkunkPlayer>(100);
		ArrayList<Roll> player1Roll = new ArrayList<Roll>(50);
		ArrayList<Roll> player2Roll = new ArrayList<Roll>(50);
		Game aGame = new Game();


		Scanner input = new Scanner(System.in);
		
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
		System.out.println(player1.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
		int to_roll = input.nextInt();
		Turn aTurn = new Turn();

		int player1Score = 0;
		int player2Score = 0;
		
		if(to_roll==2) 
		{
			System.out.println(player2.getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
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
			
		}else if(to_roll==1) 
		{
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

	}

