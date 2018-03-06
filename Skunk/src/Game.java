import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
	private ArrayList<SkunkPlayer> thePlayer;
	private ArrayList<Roll> rollList;
	private SkunkPlayer currentPlayer;
	private SkunkPlayer nextPlayer;
	private Turn aTurn;
	private int numOfPlayer;
	
	public Game(ArrayList<SkunkPlayer> playerList) 
	{
		this.thePlayer = playerList;
		rollList = new ArrayList<Roll>(50);
		currentPlayer = new SkunkPlayer("");
		nextPlayer = new SkunkPlayer("");
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
	
	public void setCurrentPlayer(SkunkPlayer currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}

	public void switchPlayer(SkunkPlayer gamePlayer) 
	{
		gamePlayer = currentPlayer;
		gamePlayer.setStatus(false);
	}
	
	public void game_control(SkunkPlayer aPlayer) 
	{
		aPlayer = thePlayer.get(0);
		Scanner input = new Scanner(System.in);

		System.out.println(aPlayer.getName()+ ", do you want to make a roll? Enter \"1\" for yes or \"2\" for no.");
		int to_roll = input.nextInt();
		aTurn = aPlayer.createTurn();
			
		if(to_roll==2) 
		{
			aPlayer.switchPlayer();
			aPlayer = thePlayer.get(1);
			game_control(aPlayer);
		}
			
		while(to_roll==1) 
		{
			Roll aRoll = aTurn.createRoll();
			if(aRoll.checkDoubleSkunk()==true) 
			{
				System.out.println("You rolled: " + aRoll.toString() + ". You rolled a double skunk.");
				to_roll = 2;
				currentPlayer.switchPlayer();
				setCurrentPlayer(thePlayer.get(1));
				thePlayer.get(1).setStatus(true);
				
			}else if(aRoll.checkSkunk()==true)
			{
				System.out.println("You rolled: " + aRoll.toString() + ". You rolled a skunk.");
				to_roll=2;
				currentPlayer.switchPlayer();
				setCurrentPlayer(thePlayer.get(1));
				thePlayer.get(1).setStatus(true);
					
			}else
			{
				System.out.println("You rolled: " + aRoll.toString() + ". Total score of this roll is: " + aRoll.getResult());
				System.out.println("player 1 score - test player" + currentPlayer.scoreUpdate());//scoreUpdate has problem
				System.out.println("Do you want to make another roll? Enter \"1\" for yes or \"2\" for no.");
				to_roll = input.nextInt();
			}
		}
	}

}
