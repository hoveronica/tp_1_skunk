import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest
{
	@Test
	public void test_scoreUpdate()
	{		
		SkunkPlayer player1 = new SkunkPlayer("Tom");
		Turn testTurn = player1.createTurn();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		assertEquals(player1.scoreUpdate_test(),12);
	}
}
