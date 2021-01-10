import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		Ghost ghost = frame.addGhost(new Location(2, 2), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		frame.startGame();

		// Location loc = new Location(2, 2);
		ArrayList<Location> arr = new ArrayList<Location>();
		arr.add(new Location(2,1));
		arr.add(new Location(1,2));

		//returns null arraylist for some reason
		ArrayList<Location> ghostArr = ghost.get_valid_moves();
		// ghostArr.add(new Location(2,1));
		// ghostArr.add(new Location(1,2));

		// System.out.println(pacMan.get_valid_moves());
		assertTrue(arr.equals(ghostArr));
	}
}
