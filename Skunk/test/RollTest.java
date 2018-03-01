import static org.junit.Assert.*;

import org.junit.Test;

public class RollTest {

	@Test
	public void test_checkSkunk() {
		LoadedDice testDice = new LoadedDice(new SimDie(new int[]{3,2,1}), new SimDie(new int[]{1,2,3})); 
		Roll testRoll = new Roll(testDice);
		assertEquals(testRoll.checkSkunk_test(),true);
	}

	@Test
	public void test_checkDoubleSkunk() {
		LoadedDice testDice = new LoadedDice(new SimDie(new int[]{1,2,3}), new SimDie(new int[]{1,2,3})); 
		Roll testRoll = new Roll(testDice);
		assertEquals(testRoll.checkDoubleSkunk_test(),true);
	}
	
}
