import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest
{
	@Test
	public void test_getRoundScore_singleTurn()
	{
		Round testRound = new Round();
		Turn testTurn1 = testRound.createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(testRound.getRoundScore_test(),12);
		testTurn1.createSkunkRoll();
		assertEquals(testRound.getRoundScore_test(),0);
		testTurn1.createDoubleSkunk();
		assertEquals(testRound.getRoundScore_test(),0);
	}
	
	@Test
	public void test_getRoundScore_multipleTurn()
	{
		Round testRound = new Round();
		Turn testTurn1 = testRound.createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(testRound.getRoundScore_test(),12);
		
		Turn testTurn2 = testRound.createTurn();
		testTurn2.createRoll_from_fakeDice();
		testTurn2.createDoubleSkunk();
		assertEquals(testRound.getRoundScore_test(),0);
		
		Turn testTurn3 = testRound.createTurn();
		testTurn3.createRoll_from_fakeDice();
		assertEquals(testRound.getRoundScore_test(),6);
		
		Turn testTurn4 = testRound.createTurn();
		testTurn4.createRoll_from_fakeDice();
		testTurn4.createSkunkRoll();
		assertEquals(testRound.getRoundScore_test(),6);
	}

}
