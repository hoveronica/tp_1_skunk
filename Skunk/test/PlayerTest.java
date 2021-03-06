import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest
{
	@Test
	public void test_getChip()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Turn testTurn1 = p1.get_currentRound().createTurn();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(p1.getChip_test(),50);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.getChip_test(),46);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.getChip_test(),42);
	}
	
	@Test
	public void test_turnScore()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Turn testTurn1 = p1.get_currentRound().createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		assertEquals(p1.getTurnScore_test(),12);
		testTurn1.createDoubleSkunk();
		assertEquals(p1.getTurnScore_test(),0);
		
		Turn testTurn2 = p1.get_currentRound().createTurn();
		testTurn2.createRoll_from_fakeDice();
		testTurn2.createRoll_from_fakeDice();
		assertEquals(p1.getTurnScore_test(),12);
	}
	
	@Test
	public void test_RoundScore()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		Turn testTurn1 = p1.get_currentRound().createTurn();
		testTurn1.createRoll_from_fakeDice();
		testTurn1.createRoll_from_fakeDice();
		
		Turn testTurn2 = p1.get_currentRound().createTurn();
		testTurn2.createRoll_from_fakeDice();
		testTurn2.createSkunkRoll();
		assertEquals(p1.getRoundScore_test(),12);
		
		//round 2 --> you want to add up the previous roundScore though
		Turn testTurn3 = p1.another_round().createTurn();
		testTurn3.createRoll_from_fakeDice();
		//assertEquals(p1.getRoundScore_test(),18);
		testTurn3.createDoubleSkunk();
		assertEquals(p1.getRoundScore_test(),0);
		
		Turn testTurn4 = p1.get_currentRound().createTurn();
		testTurn4.createRoll_from_fakeDice();
		testTurn4.createRoll_from_fakeDice();
		assertEquals(p1.getRoundScore_test(),12);
		
		
	}
	
	@Test
	public void test_with_2_players()
	{
		SkunkPlayer p1 = new SkunkPlayer("Tom");
		SkunkPlayer p2 = new SkunkPlayer("John");
		Round p1_testRound = p1.get_currentRound();
		Round p2_testRound = p2.get_currentRound();
		
		//simulate rolling multiple rolls in a turn
		Turn p1_testTurn1 = p1_testRound.createTurn();
		p1_testTurn1.createRoll_from_fakeDice();
		p1_testTurn1.createRoll_from_fakeDice();
		Turn p2_testTurn1 = p2_testRound.createTurn();
		p2_testTurn1.createRoll_from_fakeDice();
		p2_testTurn1.createSkunkRoll();
		
		assertEquals(p1.getRoundScore_test(),12);
		assertEquals(p2.getRoundScore_test(),0);
		assertEquals(p1.getChip_test(),50);
		assertEquals(p2.getChip_test(),49);
		
		Turn p1_testTurn2 = p1_testRound.createTurn();
		p1_testTurn2.createRoll_from_fakeDice();
		p1_testTurn2.createSkunkRoll();
		Turn p2_testTurn2 = p2_testRound.createTurn();
		p2_testTurn2.createRoll_from_fakeDice();
		p1.chipUpdate_test();
		p2.chipUpdate_test();
		
		Turn p1_testTurn3 = p1_testRound.createTurn();
		p1_testTurn3.createRoll_from_fakeDice();
		p1_testTurn3.createRoll_from_fakeDice();
		Turn p2_testTurn3 = p2_testRound.createTurn();
		p2_testTurn3.createRoll_from_fakeDice();
		p2_testTurn3.createDeduce();
		
		assertEquals(p1.getTurnScore_test(),12);
		//assertEquals(p1.getRoundScore_test(),24);
		assertEquals(p1.getChip_test(),49);
		assertEquals(p2.getTurnScore_test(),0);
		assertEquals(p2.getRoundScore_test(),6);
		assertEquals(p2.getChip_test(),47);
	}
	
}
