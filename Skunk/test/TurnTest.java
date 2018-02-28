import static org.junit.Assert.*;

import org.junit.Test;

public class TurnTest
{

	@Test
	public void test_createRoll()
	{
		Turn testTurn = new Turn();
		Roll testRoll = testTurn.createRoll();
		//using LoadedDice to test the roll functions
	}

}
