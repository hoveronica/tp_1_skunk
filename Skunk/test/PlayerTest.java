import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest
{
	@Test
	public void test_chipUpdate()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Round testRound = p1.getRound();
		Turn testTurn1 = testRound.createTurn();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(p1.chipUpdate_test(),50);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.chipUpdate_test(),46);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.chipUpdate_test(),42);
	}
	
	@Test
	public void test_turnScore()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Round testRound = p1.getRound();
		Turn testTurn1 = testRound.createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(p1.getTurnScore_test(),12);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.getTurnScore_test(),0);
		
		Turn testTurn2 = testRound.createTurn();
		testTurn2.createRoll_from_fakeDice();
		testTurn2.createRoll_from_fakeDice();
		assertEquals(p1.getTurnScore_test(),12);
	}
	
	@Test
	public void test_RoundScore()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Round testRound = p1.getRound();
		Turn testTurn1 = testRound.createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		
		Turn testTurn2 = testRound.createTurn();
		testTurn2.createRoll_from_fakeDice();
		testTurn2.createSkunkRoll();
		assertEquals(p1.getRoundScore_test(),12);
		
		Round testRound2 = p1.getRound();
		Turn testTurn3 = testRound2.createTurn();
		testTurn3.createRoll_from_fakeDice();
		testTurn3.createDoubleSkunk();
		assertEquals(p1.getRoundScore_test(),0);
		
		Turn testTurn4 = testRound2.createTurn();
		testTurn4.createRoll_from_fakeDice();
		assertEquals(p1.getRoundScore_test(),6);
	}
	
}
