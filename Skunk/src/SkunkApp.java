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
			System.out.println("The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining the points on the two dice.\r\n"
					+ "For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and turns up a 3 and 5 (8 points), he would then have an \r\n"
					+ "accumulated total of 17 points for the two rolls. The player has the privilege of continuing to shake to increase his score or of passing the dice to wait\r\n"
					+ "for the next series, thus preventing the possibility of rolling a Skunk and losing his score.\r\n" + 
					"\r\n" + "PENALTIES:\r\n" + "\r\n" + "* A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\r\n" + 
					"\r\n" + "* A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\r\n" + 
					"\r\n" + "* TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.\r\n" + 
					"\r\n" + "* Any number can play. The suggested number of chips to start is 50. There are sufficient chips in the box to allow 8 players to start with 50 chips by \r\n"
							+ "placing a par value of \"one\" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.\r\n" + 
					"\r\n" + "The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. When he decides to stop, \r\n"
							+ "his total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\r\n" + 
					"\r\n" + "The winner of each game collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score..\r\n");

			System.out.println("Game on!\r\n");
		}

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
				System.out.println("You must put in a number!");
				input.next();
			}
		}while(num_of_player<=1);
		
		aGame.addPlayer(num_of_player);
		System.out.println("Let's get rolling!");
		
		aGame.first_round();
		while(aGame.check_score()==false) {
			aGame.one_round();
		}
		if(aGame.check_score()==true)
			aGame.last_round();
		
		System.out.println("Thanks for playing skunk game! Hope you enjoyed the match!");
	}
}

