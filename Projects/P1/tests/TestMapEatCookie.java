import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase {

	public void testMapEatCookie() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Map map = frame.getMap();

		assertTrue(map.eatCookie("tok_x0_y0") == null);
		assertTrue(map.getCookies() == 0);

		assertTrue(map.getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));
		assertTrue(map.eatCookie("tok_x1_y1").getClass().equals(CookieComponent.class));
		assertTrue(!map.getLoc(new Location(1, 1)).contains(Map.Type.COOKIE));
		assertTrue(map.getCookies() == 1);
	}
}
