
public class Roll {

	private int result=0;
	private Dice d1;
	private int numOfRoll=0;
	private boolean rollAgain;
	
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
	
	public void roll_again(boolean roll){
		while(roll==true){
			numOfRoll++;
		}
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