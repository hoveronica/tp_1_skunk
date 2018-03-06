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
	
		if(playerList.get(0).turnStatus()==true) 
		{
			aGame.game_control(playerList.get(0));
		}
		else if (playerList.get(1).turnStatus()==true)
		{
			aGame.game_control(playerList.get(1));
		}
		
		System.out.println(playerList.get(0).getName() + " scores " + player1.getScore() + " and " + playerList.get(1).getName() + " scores " + player2.getScore());
			
		}
	
	}

