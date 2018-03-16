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
	
	
}
