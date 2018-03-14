import static org.junit.Assert.*;

import org.junit.Test;

public class TurnTest
{

	@Test
	public void test_createRoll()
	{
		Turn testTurn = new Turn();
		Roll testRoll = testTurn.createRoll_from_fakeDice();
		assertEquals(testRoll.getResult(),6);
	}
	
	@Test
	public void test_addScore()
	{
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.addScore_test(),6);
		testTurn.createSkunkRoll();
		assertEquals(testTurn.addScore_test(),6);
		testTurn.createDoubleSkunk();
		assertEquals(testTurn.addScore_test(),0);
	}
	
	@Test
	public void test_addScore_noSkunk()
	{
		Turn testTurn = new Turn();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		assertEquals(testTurn.addScore_test(),24);
	}

}
