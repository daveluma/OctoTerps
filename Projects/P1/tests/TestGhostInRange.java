import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacMan = frame.addPacMan(new Location(1, 0));
		Ghost ghost1 = frame.addGhost(new Location(3, 0), "Clyde", Color.BLACK);

		assertTrue(pacMan.is_ghost_in_range() == false);

		Ghost ghost2 = frame.addGhost(new Location(2, 0), "Boris", Color.BLUE);

		assertTrue(pacMan.is_ghost_in_range() == true);
	}
}

