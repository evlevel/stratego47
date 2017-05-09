import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRobot
{
	private RobotPlayer robbie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}

	@Before
	public void setUp() throws Exception
	{
		robbie = new RobotPlayer(1);
	}

	@Test
	public void testRandomFromTo1()
	{
		assertTrue("0-0", 0==robbie.randomFromTo(0, 0));
		
		int r = robbie.randomFromTo(0, 1);
		
		assertTrue("0-1", 0 <= r && r <= 1);
		
		r = robbie.randomFromTo(46, 48);
		assertTrue("46-48", 46 <= r && r <= 48);
	
		r = robbie.randomFromTo(-10, 10);
		assertTrue("-10-10", -10 <= r && r <= 10);

	}

}
