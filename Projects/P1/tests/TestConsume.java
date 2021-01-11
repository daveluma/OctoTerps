import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display

		PacMan pacMan = frame.addPacMan(new Location(1, 0));
		assertTrue(pacMan.consume() == null);

		pacMan = frame.addPacMan(new Location(1, 1));
		assertTrue(pacMan.consume() != null);

	}
}
