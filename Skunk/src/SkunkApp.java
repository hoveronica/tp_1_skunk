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
		int num_of_player =	0;
	
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
		//make it to 2-player game
		do {
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
		}while(num_of_player<=1);
		
		aGame.addPlayer(num_of_player);
		System.out.println("Let's get rolling!");
		
		while(aGame.check_score()==false) {
			aGame.one_round();
		}
		if(aGame.check_score()==true)
			aGame.last_round();
		
		System.out.println("Thanks for playing skunk game! Hope you enjoyed the match!");
	}
}

