import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacMan = frame.addPacMan(new Location(1, 0));
		Ghost ghost = frame.addGhost(new Location(3, 0), "Clyde", Color.BLACK);

		assertTrue(!ghost.is_pacman_in_range());

		pacMan = frame.addPacMan(new Location(2, 0));

		assertTrue(ghost.is_pacman_in_range());
	}
}
