import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();

		Ghost ghost = frame.addGhost(new Location(1,0), "Boban", Color.DARK_GRAY);
		for (int i=0; i<4; i++)
			assertTrue(ghost.move());
	}
}
