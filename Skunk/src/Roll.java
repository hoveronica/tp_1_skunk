
public class Roll {

	private int result;
	private Dice d1;
	private int numOfRoll;

	
	public Roll(Dice gameDice){
		this.d1=gameDice;
	}	
	
	public boolean checkSkunk(){
		if (d1.getLastRoll_die1() == 1 || d1.getLastRoll_die2()==1)
		return true;
		else
			return false;
	}
	
	public boolean checkDoubleSkunk(){
		if(d1.getLastRoll_die1()==1 && d1.getLastRoll_die2()==1)
			return true;
		else return false;
	}
	
	public void roll(){
<<<<<<< HEAD
			numOfRoll++;
=======
		numOfRoll++;
>>>>>>> branch 'master' of https://github.com/hoveronica/tp_1_skunk.git
	}
	
	public void endRoll(){
		for(int i=0; i<numOfRoll;i++){
			result += d1.getLastRoll_sum();
		}
	}
	
	public int getResult(){
		return result;
	}
}
