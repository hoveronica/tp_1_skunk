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
		Game aGame = new Game(playerList);
			
		System.out.println("Welcome to Skunk game!");
	
		//create players
		System.out.println("How many players are there in this game?");
		int num_of_player = input.nextInt();
		aGame.addPlayer(num_of_player);
		SkunkPlayer active_player = aGame.getCurrent_player();
			
		//start rolling
		System.out.println("Let's get rolling!");
		
		while(active_player.turnStatus()==true) 
		{
			aGame.game_control(active_player);
			
		}
	
		System.out.println(playerList.get(0).getName() + " scores " + playerList.get(0).getScore() + " and " + playerList.get(1).getName() + " scores " + playerList.get(1).getScore());
			
		}
	
}
