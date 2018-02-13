import static org.junit.Assert.*;

import org.junit.Test;

public class SimDieTest
{

	@Test
	public void test_constructor()
	{
		SimDie d = new SimDie(new int[] {1,2,3});
	}

	@Test
	public void test_roll_once()
	{
		SimDie d = new SimDie(new int[] {1,2,3});
		d.roll();
		assertEquals(d.getLastRoll(),1);
	}
	

	@Test
	public void test_roll_twice()
	{
		SimDie d = new SimDie(new int[] {1,2,3});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
	}
	
	
	


	

}
