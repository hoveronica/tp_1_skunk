import java.util.ArrayList;
import java.util.Scanner;

public class SkunkApp 
{

	public static void main(String[] args)
	{
		//initiates scanner object
		Scanner input = new Scanner(System.in);

		//create attributes
		ArrayList<SkunkPlayer> playerList = new ArrayList<SkunkPlayer>(100);
		int to_roll;
			
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
		Game aGame = new Game(playerList);
		System.out.println("Let's get rolling!");
		aGame.setCurrentPlayer(playerList.get(0));
		playerList.get(0).setStatus(true);
	
		while(playerList.get(0).turnStatus()==true) 
		{
			System.out.println(playerList.get(0).getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn player1Turn = playerList.get(0).createTurn();
			
			if(to_roll==2) 
			{
				playerList.get(0).switchPlayer();
				aGame.setCurrentPlayer(playerList.get(1));
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = player1Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					player1Turn.addScore();
					playerList.get(0).switchPlayer();
					aGame.setCurrentPlayer(playerList.get(1));
					playerList.get(1).setStatus(true);
					
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					player1Turn.addScore();
					playerList.get(0).switchPlayer();
					aGame.setCurrentPlayer(playerList.get(1));
					playerList.get(1).setStatus(true);
					
				}else
				{
					System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
					player1Turn.addScore();
					//System.out.println("player 1 score " + player1Turn.addScore());
					System.out.println("player 1 score - test player" + player1.scoreUpdate());
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			}

			
		}
		while(playerList.get(1).turnStatus()==true)
		{
			System.out.println(playerList.get(1).getName()+", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
			to_roll = input.nextInt();
			Turn player2Turn = playerList.get(1).createTurn();
			
			if(to_roll==2) 
			{
				playerList.get(1).switchPlayer();
				aGame.setCurrentPlayer(playerList.get(0));
			}
			
			while(to_roll==1) 
			{
				Roll aRoll = player2Turn.createRoll();
				if(aRoll.checkDoubleSkunk()==true) 
				{
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
					player2Turn.addScore();
					playerList.get(1).switchPlayer();
					aGame.setCurrentPlayer(playerList.get(0));
					playerList.get(0).setStatus(true);
					
				}else if(aRoll.checkSkunk()==true)
				{
					System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
					player2Turn.addScore();
					playerList.get(1).switchPlayer();
					aGame.setCurrentPlayer(playerList.get(0));
					playerList.get(0).setStatus(true);
					
				}else
				{
					System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
					player2Turn.addScore();
					System.out.println("player 2 score " + player2Turn.addScore());
					System.out.println("player 2 score - test player" + player2.scoreUpdate());
					
					System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
					to_roll = input.nextInt();
				}
			}

		}
		
	
		System.out.println(playerList.get(0).getName() + " scores " + player1.getScore() + " and " + playerList.get(1).getName() + " scores " + player2.getScore());
			
		}
	
	}

