import static org.junit.Assert.*;

import org.junit.Test;

public class TurnTest
{

	@Test
	public void test_createRoll()
	{
		Turn testTurn = new Turn();
		Roll testRoll = testTurn.createRoll_from_fakeDice();
		assertEquals(testRoll.getResult(),5);
	}
	
	@Test
	public void test_addScore()
	{
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		testTurn.addScore_test();
		assertEquals(testTurn.getTurnScore(),0);
	}

}
