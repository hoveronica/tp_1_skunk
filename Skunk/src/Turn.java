
public class Turn
{
	private Roll gameRoll;
	private int turnScore;
	
	
	public Turn(Roll theRoll) {
		this.gameRoll=theRoll;
	}
	
	public void passDice() {
		if (gameRoll.checkDoubleSkunk()==true) {
			turnScore = 0;
		}else if(gameRoll.checkSkunk()==true) {
			turnScore = gameRoll.getResult();
		}else {
			
		}
	}
	
	public int addScore() {
		
		
		return turnScore;
	}
	
}
