import static org.junit.Assert.*;

import org.junit.Test;

public class LoadedDiceTest
{
	
	@Test
	public void test_roll()
	{
		SimDie d1 = new SimDie(new int[]{1,2,3,4,5,6});
		SimDie d2 = new SimDie(new int[] {6,5,4,3,2,1});
		LoadedDice gameDice = new LoadedDice(d1,d2);
		gameDice.dice_roll();
		assertEquals(gameDice.dice_getLastRoll_die1(),1);
		assertEquals(gameDice.dice_getLastRoll_die2(),6);
		assertEquals(gameDice.dice_getLastRoll_sum(),7);
		gameDice.dice_roll();
		gameDice.dice_roll();
		assertEquals(gameDice.dice_getLastRoll_die1(),3);
		assertEquals(gameDice.dice_getLastRoll_die2(),4);
		assertEquals(gameDice.dice_getLastRoll_sum(),7);
	}

	@Test
	public void test_roll_d1_longer()
	{
		SimDie d1 = new SimDie(new int[]{1,2,3});
		SimDie d2 = new SimDie(new int[] {4,5});
		LoadedDice gameDice = new LoadedDice(d1,d2);
		gameDice.dice_roll();
		gameDice.dice_roll();
		gameDice.dice_roll();
		assertEquals(gameDice.dice_getLastRoll_die1(),3);
		assertEquals(gameDice.dice_getLastRoll_die2(),4);
	}
	
	@Test
	public void test_roll_d2_longer()
	{
		SimDie d1 = new SimDie(new int[]{1,2});
		SimDie d2 = new SimDie(new int[] {1,2,3,4});
		LoadedDice gameDice = new LoadedDice(d1,d2);
		gameDice.dice_roll();
		gameDice.dice_roll();
		gameDice.dice_roll();
		gameDice.dice_roll();
		assertEquals(gameDice.dice_getLastRoll_die1(),2);
		assertEquals(gameDice.dice_getLastRoll_die2(),4);
	}
}
