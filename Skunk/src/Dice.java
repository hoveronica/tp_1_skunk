
public class Dice {

	private RandomDie d1;
	private RandomDie d2;
	
	public Dice(RandomDie d1, RandomDie d2)
	{
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public void Roll(){
		d1.roll();
		d2.roll();
	}
	
	public int getLastRoll_die1() 
	{
		return d1.getLastRoll();
	}
	
	public int getLastRoll_die2() 
	{
		return d2.getLastRoll();
	}
	
	public int getLastRoll_sum() 
	{
		return d1.getLastRoll()+d2.getLastRoll();
	}
}
