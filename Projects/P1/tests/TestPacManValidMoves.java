import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(2, 1));
		arr.add(new Location(1, 2));
		ArrayList<Location> movespac = pacMan.get_valid_moves();
		assertEquals(arr, movespac);
	}

	public void testPacManGhostMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		Ghost ghost = frame.addGhost(new Location(1, 2), "name", Color.red); // Creates a red ghost named "name" at
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(2, 1));
		// arr.add(new Location(1, 2));
		ArrayList<Location> movespac = pacMan.get_valid_moves();
		assertEquals(arr, movespac);
	}
	public void testPacManValidMovesManyMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacMan = frame.addPacMan(new Location(3, 2));
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(3, 1));
		arr.add(new Location(3, 3));
		arr.add(new Location(4, 1));
		arr.add(new Location(2, 1));
		arr.add(new Location(4, 3));
		ArrayList<Location> movespac = pacMan.get_valid_moves();
		assertEquals(arr, movespac);
	}
}
