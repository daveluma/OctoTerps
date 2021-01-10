import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException{
		
		boolean torf = true;
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacMan = frame.addPacMan(new Location(2, 2));
		frame.initPlayers();
		frame.startGame();

		// Location loc = new Location(2, 2);
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(3,2));
		arr.add(new Location(2,3));

		ArrayList<Location> movespac = pacMan.get_valid_moves();

		if (movespac.size() != arr.size()) {
			torf = false;
		} else {
			for (int i = 0; i < arr.size(); i++) {
				Location l = movespac.get(i);
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
