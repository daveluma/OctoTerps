import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove {

	public void testMapMove() {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(2, 4), "Bobi", Color.MAGENTA);
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		Map map = frame.getMap();

		assertTrue(map.move("pacman", new Location (1,1), Map.Type.PACMAN));
		assertTrue(map.move("Bobi", new Location(2, 4), Map.Type.GHOST));
	}
}
