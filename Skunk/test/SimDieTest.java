import static org.junit.Assert.*;

import org.junit.Test;

public class SimDieTest
{
	/*
	 * * removed test_constructor test because it is being tested in all the following tests
	 */
	/*
	 * reduce redundant rolling tests
	 * */
	@Test
	public void test_roll()
	{
		SimDie d = new SimDie(new int[] {1,2,3,4,5,6});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),3);
		d.roll();
		assertEquals(d.getLastRoll(),4);
		d.roll();
		assertEquals(d.getLastRoll(),5);
		d.roll();
		assertEquals(d.getLastRoll(),6);
	}
	
	@Test
	public void test_roll_wrap_around()
	{
		SimDie d = new SimDie(new int[] {1,2,3,4,5,6});
		d.roll();
		d.roll();
		d.roll();
		d.roll();
		d.roll();
		d.roll();
		
		/*
		 * after rolling 6 times, the 7th roll should start from pos 0 again
		 */
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
	
	}

}
