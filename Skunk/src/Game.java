import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	private ArrayList<SkunkPlayer> thePlayer;
	private ArrayList<Roll> rollList;
	private Turn aTurn;
	private int numOfPlayer;
	
	public Game() 
	{
		thePlayer = new ArrayList<SkunkPlayer>(100);
		rollList = new ArrayList<Roll>(50);
		aTurn = new Turn();
		numOfPlayer = 0;
	}
	
	public SkunkPlayer addPlayer(String name) 
	{
		SkunkPlayer aPlayer = new SkunkPlayer(name);
		thePlayer.add(aPlayer);
		numOfPlayer++;
		return aPlayer;
	}
	
	//compare all players and get winning player's name + score
	public String winningPlayer() 
	{
		SkunkPlayer winner = new SkunkPlayer("");
		int winning_score = 0;
		for(int x = 0; x < thePlayer.size(); x++)
		{
			if(thePlayer.get(x).getScore()>winning_score)
			{
				winning_score = thePlayer.get(x).getScore();
				winner = thePlayer.get(x);
			}
		}
		return "The winner is: " + winner.getName() + ", with " + winner.getScore() + " points!";
	}
	
	public int getNumOfPlayer() 
	{
		return numOfPlayer;
	}
	
	/*public int game_control(int proceed) 
	{
		Scanner input = new Scanner(System.in);

		while(proceed==1) 
		{
			Roll aRoll = aTurn.createRoll();
			if(aRoll.checkDoubleSkunk()==true) 
			{
				System.out.println("You rolled a double skunk.");
				rollList.add(aRoll);
				break;
			}else if(aRoll.checkSkunk()==true)
			{
				System.out.println("You rolled a skunk.");
				rollList.add(aRoll);
				break;
			}else
			{
				System.out.println("You rolled a " + aRoll.getResult());
				rollList.add(aRoll);
				System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
				proceed = input.nextInt();
			}
		}
		
		if(proceed==2) {
			System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
			proceed = input.nextInt();
			game_control(proceed);
		}
		return aTurn.addScore();
	}*/
	
}
