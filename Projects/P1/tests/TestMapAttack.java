import java.awt.Color;
import junit.framework.*;
import java.io.*;

public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red);
		PacMan pacman = frame.addPacMan(new Location(3, 3));
		Map map = frame.getMap(); 

		assertTrue(!map.isGameOver());

		pacman = frame.addPacMan(new Location(1, 2));

		ghost.attack();

		assertTrue(map.isGameOver());
	}
}
