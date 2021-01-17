import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacMan = frame.addPacMan(new Location(4, 4));
		Ghost ghost = frame.addGhost(new Location(1, 2), "Clyde", Color.BLACK);

		assertTrue(!ghost.is_pacman_in_range());

		pacMan = frame.addPacMan(new Location(3, 4));

		assertTrue(ghost.is_pacman_in_range());
	}
}
