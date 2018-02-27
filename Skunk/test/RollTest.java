import static org.junit.Assert.*;

import org.junit.Test;

public class RollTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void test_result() {
		Dice testDice = new Dice (new RandomDie(),new RandomDie());
		Roll testRoll = new Roll(testDice);
		testRoll.roll_again(true);
		assertEquals(testRoll.getResult(),testDice.getLastRoll_sum());
	}

}
