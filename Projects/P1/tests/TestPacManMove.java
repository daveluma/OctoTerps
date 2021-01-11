import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		PacMan pacman = frame.addPacMan(new Location(1,0));
		assertTrue(pacman.move());
	}
}
