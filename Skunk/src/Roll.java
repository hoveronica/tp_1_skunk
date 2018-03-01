
public class Roll {

	private int result;
	private Dice d1;
	private LoadedDice testDice;
	
	public Roll(LoadedDice test) {
		this.testDice = test;
		test.dice_roll();
		result = test.dice_getLastRoll_sum();
	}
	
	public Roll(Dice gameDice){
		this.d1 = gameDice;
		gameDice.Roll();
		result = gameDice.getLastRoll_sum();
		
	}	

	//for testing
	public boolean checkSkunk_test() {
		if (testDice.dice_getLastRoll_die1() == 1 || testDice.dice_getLastRoll_die2()==1)
			return true;
			else
				return false;
	}
	
	//for testing
	public boolean checkDoubleSkunk_test(){
		if(testDice.dice_getLastRoll_die1()==1 && testDice.dice_getLastRoll_die2()==1)
			return true;
		else return false;
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

	public int getResult(){
		return result;
	}
}
