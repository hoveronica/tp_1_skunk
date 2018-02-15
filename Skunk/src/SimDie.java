
public class SimDie
{
	private int nextPos;
	private int lastRoll;
	private int[] diceSeq;

	public SimDie(int[] iArray)
	{
		this.diceSeq = iArray;
		this.nextPos = 0;
		this.lastRoll = 0;
	}
	
	/**
	 * add getters and setters for easier access for LoadedDice class
	 */
	public int getNextPos()
	{
		return nextPos;
	}

	private void setNextPos(int nextPos)
	{
		this.nextPos = nextPos;
	}

	public int[] getDiceSeq()
	{
		return diceSeq;
	}

	private void setDiceSeq(int[] diceSeq)
	{
		this.diceSeq = diceSeq;
	}

	private void setLastRoll(int lastRoll)
	{
		this.lastRoll = lastRoll;
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
