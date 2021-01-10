import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		boolean torf = true;
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		Ghost ghost = frame.addGhost(new Location(2, 2), "billy", Color.red); // Creates a red ghost named "name" at
		frame.initPlayers();
		frame.startGame();

		// Location loc = new Location(2, 2);
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(3,2));
		arr.add(new Location(2,3));

		ArrayList<Location> movesGhost = ghost.get_valid_moves();

		if (movesGhost.size() != arr.size()) {
			torf = false;
		} else {
			for (int i = 0; i < arr.size(); i++) {
				Location l = movesGhost.get(i);
				if (!arr.contains(l)) {
					torf = false;
					break;
				}
				l = null;
			}
		}

		assertTrue(torf);
	}
}
