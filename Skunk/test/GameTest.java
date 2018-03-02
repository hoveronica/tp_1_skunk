import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest
{

	@Test
	public void test_num_of_player()
	{
		Game testGame = new Game();
		testGame.addPlayer("Tom");
		testGame.addPlayer("John");
		testGame.addPlayer("Clark");
		assertEquals(testGame.getNumOfPlayer(),3);
	}
	
	@Test
	public void test_winningPlayer()
	{
		Game testGame = new Game();
		SkunkPlayer player1 = testGame.addPlayer("Tom");
		SkunkPlayer player2 = testGame.addPlayer("John");
		SkunkPlayer player3 = testGame.addPlayer("Clark");
		player1.setPlayerTotalScore(20);
		player2.setPlayerTotalScore(30);
		player3.setPlayerTotalScore(50);
		assertEquals(testGame.winningPlayer(), "The winner is: Clark, with 50 points!");
		SkunkPlayer player4 = testGame.addPlayer("Becky");
		player4.setPlayerTotalScore(10);
		assertEquals(testGame.winningPlayer(), "The winner is: Clark, with 50 points!");
	}

}
