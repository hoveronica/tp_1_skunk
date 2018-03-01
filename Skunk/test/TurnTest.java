import static org.junit.Assert.*;

import org.junit.Test;

public class TurnTest
{

	@Test
	public void test_createRoll()
	{
		LoadedDice testDice = new LoadedDice(new SimDie(new int[]{1,2,3}), new SimDie(new int[]{1,2,3})); 
		Turn testTurn = new Turn();
		Roll testRoll = testTurn.createRoll_from_fakeDice();
		assertEquals(testRoll.getResult(),2);
	}
	
	@Test
	public void test_addScore()
	{
		LoadedDice testDice = new LoadedDice(new SimDie(new int[]{1,2,3}), new SimDie(new int[]{1,2,3})); 
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		testTurn.addScore_test();
		assertEquals(testTurn.getTurnScore(),0);
	}

}
