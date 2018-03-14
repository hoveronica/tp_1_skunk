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
		assertEquals(player1.scoreUpdate_test(),6);
		testTurn.createRoll_from_fakeDice();
		assertEquals(player1.scoreUpdate_test(),12);
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		assertEquals(player1.scoreUpdate_test(),30);
		
	}
	
	@Test
	public void test_scoreUpdate_with_skunk()
	{		
		SkunkPlayer player1 = new SkunkPlayer("Tom");
		Turn testTurn = player1.createTurn();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createSkunkRoll();
		assertEquals(player1.scoreUpdate_test(),18);
	}
	
	@Test
	public void test_scoreUpdate_doubleSkunk()
	{		
		SkunkPlayer player1 = new SkunkPlayer("Tom");
		Turn testTurn = player1.createTurn();
		testTurn.createRoll_from_fakeDice();
		testTurn.createRoll_from_fakeDice();
		testTurn.createDoubleSkunk();
		assertEquals(player1.scoreUpdate_test(),0);
	}
}
