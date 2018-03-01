import java.util.Scanner;

//score the roll and update the roll score
//create a turn
//make roll--> score the roll --> update score 
//keep track of numOfRoll
//ask if the turn is over(comes from skunk and player choice) DONE
//
public class Turn
{
	private Roll[] gameRoll; //array, how to keep track of Roll pos?
	private int turnScore;
	private int numOfRoll;
	
	
	public Turn() 
	{
		
	}
	
	public Roll createRoll() {
		Roll aRoll = new Roll(new Dice (new RandomDie(), new RandomDie()));
		numOfRoll++;
		return aRoll;
	}
	
	/*public void passDice() {
		if (gameRoll.checkDoubleSkunk()==true) {
			turnScore = 0;
		}else if(gameRoll.checkSkunk()==true) {
			turnScore = gameRoll.getResult();
		}else {
			
		}
	}
	*/
	
	public int addScore() {
		return turnScore;
	}
	
	public boolean turnStatus() {
		Scanner answer = new Scanner(System.in);
		System.out.println("Do you want to roll again?");
		Object rolls = answer.next();
		boolean skunk = false;
		if (rolls.equals("yes")) {
			skunk = false;
		} 
		if (rolls.equals("no")) {
			skunk = true;
	}
		return skunk;
	
}
}
