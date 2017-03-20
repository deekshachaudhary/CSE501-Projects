package studio7;

import static org.junit.Assert.*;

import org.junit.Test;

public class HockeyPlayerTest {

	HockeyPlayer crosby = new HockeyPlayer("Sidney Crosby",
						5, 21, 11, 39, "Left", "Right");
	HockeyPlayer gretzky = new HockeyPlayer("Wayne Gretzky",
						6, 33, 16, 38, "Both", "Right");
	HockeyPlayer ovechkin = new HockeyPlayer("Alexander Ovechkin",
						8, 11, 5, 10, "Right", "Left");
	HockeyPlayer stamkos = new HockeyPlayer("Steven Stamkos",
						16, 14, 23, 38, "Left", "Right");
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void playerNameTest() {
		
		assertEquals("Sidney Crosby", crosby.getPlayerName());
		assertEquals("Wayne Gretzky", gretzky.getPlayerName());
		assertEquals("Alexander Ovechkin", ovechkin.getPlayerName());
		assertEquals("Steven Stamkos", stamkos.getPlayerName());
	}
	
	@Test
	public void jerseyNumberTest() {
		assertEquals(5,crosby.getJerseyNum());
		assertEquals(6,gretzky.getJerseyNum());
		assertEquals(8,ovechkin.getJerseyNum());
		assertEquals(16,stamkos.getJerseyNum());
		
	}

	@Test
	public void numPointsTest() {
		assertEquals(32,crosby.getNumPoints());
		assertEquals(49,gretzky.getNumPoints());
		assertEquals(16,ovechkin.getNumPoints());
		assertEquals(37,stamkos.getNumPoints());	
	}
	
	@Test
	public void numGamesPlayedTest() {
		assertEquals(32,crosby.getNumPoints());
		assertEquals(49,gretzky.getNumPoints());
		assertEquals(16,ovechkin.getNumPoints());
		assertEquals(37,stamkos.getNumPoints());	
	}
	
	@Test
	public void shootLeftRightBothTest() {
		assertEquals("Left",crosby.getShootLeftRightBoth());
		assertEquals("Both",gretzky.getShootLeftRightBoth());
		assertEquals("Right",ovechkin.getShootLeftRightBoth());
		assertEquals("Left",stamkos.getShootLeftRightBoth());
	}
	
	@Test
	public void leftOrRightHandedTest() {
		assertEquals("Right",crosby.getLeftOrRightHanded());
		assertEquals("Right",gretzky.getLeftOrRightHanded());
		assertEquals("Left",ovechkin.getLeftOrRightHanded());
		assertEquals("Right",stamkos.getLeftOrRightHanded());
	}
}
