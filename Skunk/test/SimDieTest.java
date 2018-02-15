import static org.junit.Assert.*;

import org.junit.Test;

public class SimDieTest
{
	/*
	 * * removed test_constructor test because it is being tested in all the following tests
	 */
	
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
	
	@Test
	public void test_roll_three_times()
	{
		SimDie d = new SimDie(new int[] {1,2,3});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),3);
	}
	
	@Test
	public void test_roll_three_times_two_values()
	{
		SimDie d = new SimDie(new int[] {1,2});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),1);
	}
	
	@Test
	public void test_roll_four_times_two_values()
	{
		SimDie d = new SimDie(new int[] {1,2});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
	}
	
	@Test
	public void test_roll_five_times_two_values()
	{
		SimDie d = new SimDie(new int[] {1,2});
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),1);
		d.roll();
		assertEquals(d.getLastRoll(),2);
		d.roll();
		assertEquals(d.getLastRoll(),1);
	}

}
