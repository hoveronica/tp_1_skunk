
public class SimDie
{
	private int nextPos = 0;
	private int lastRoll = 0;
	private int[] diceSeq;

	public SimDie(int[] iArray)
	{
		this.diceSeq = iArray;
	}
	
	public void roll()
	{
		if(nextPos < diceSeq.length) {
			lastRoll = diceSeq[nextPos];
			nextPos++;
		}else {
			nextPos = 0;
			lastRoll = diceSeq[nextPos];
			nextPos++;
		}
		
	}
	
	public int getLastRoll()
	{
		return lastRoll;
	}
	
}
