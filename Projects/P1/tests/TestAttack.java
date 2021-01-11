import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location(1, 1), "Testy", Color.WHITE);
		assertTrue(!ghost.attack());
		frame.addPacMan(new Location(0, 1));
		assertTrue(ghost.attack());
	}
}
