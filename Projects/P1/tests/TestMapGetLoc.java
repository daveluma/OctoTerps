import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.HashSet;
import org.junit.Assert;

public class TestMapGetLoc extends TestCase {
	
	public void testMapGetLoc1()  throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		Ghost ghost = frame.addGhost(new Location(1, 3), "name", Color.red); // Creates a red ghost named "name" at
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		Map map = frame.getMap(); 

		HashSet<Map.Type> setGhost = new HashSet<Map.Type>();
		setGhost.add(Map.Type.COOKIE);
		setGhost.add(Map.Type.GHOST);
		HashSet<Map.Type> setPacman = new HashSet<Map.Type>();
		setPacman.add(Map.Type.COOKIE);
		setPacman.add(Map.Type.PACMAN);

		HashSet<Map.Type> setCookie = new HashSet<Map.Type>();
		setCookie.add(Map.Type.COOKIE);
		
		HashSet<Map.Type> setWall = new HashSet<Map.Type>();
		setWall.add(Map.Type.WALL);

		HashSet<Map.Type> setEmpty = new HashSet<Map.Type>();
		setEmpty.add(Map.Type.EMPTY); 

		assertEquals(map.getLoc(new Location(1,3)), setGhost);
		assertEquals(map.getLoc(new Location(1,1)), setPacman);
		assertEquals(map.getLoc(new Location(2,1)), setCookie);
		assertEquals(map.getLoc(new Location(3,2)), setWall);
		assertEquals(map.getLoc(new Location(-5,-6)), setEmpty);

	}

	public void testMapGetLoc2()  throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		Map map = frame.getMap(); 

		HashSet<Map.Type> setPacman = new HashSet<Map.Type>();
		setPacman.add(Map.Type.COOKIE);
		setPacman.add(Map.Type.PACMAN);

		HashSet<Map.Type> setWall = new HashSet<Map.Type>();
		setWall.add(Map.Type.WALL);

		HashSet<Map.Type> setEmpty = new HashSet<Map.Type>();
		setEmpty.add(Map.Type.EMPTY);

		assertEquals(map.getLoc(new Location(1,1)), setPacman);
		assertEquals(map.getLoc(new Location(3,2)), setWall);
		assertEquals(map.getLoc(new Location(400,40)), setEmpty);

	}

	public void testMapGetLoc3()  throws FileNotFoundException {
		NoFrame frame = new NoFrame(); // Creates A New Map With Walls and Tokens w/o a Display
		Ghost ghost = frame.addGhost(new Location(11, 1), "name", Color.red); // Creates a red ghost named "name" at
		PacMan pacMan = frame.addPacMan(new Location(1, 1));
		Map map = frame.getMap(); 

		HashSet<Map.Type> setGhost = new HashSet<Map.Type>();
		setGhost.add(Map.Type.COOKIE);
		setGhost.add(Map.Type.GHOST);
		HashSet<Map.Type> setPacman = new HashSet<Map.Type>();
		setPacman.add(Map.Type.COOKIE);
		setPacman.add(Map.Type.PACMAN);

		HashSet<Map.Type> setCookie = new HashSet<Map.Type>();
		setCookie.add(Map.Type.COOKIE);

		HashSet<Map.Type> setEmpty = new HashSet<Map.Type>();
		setEmpty.add(Map.Type.EMPTY);

		HashSet<Map.Type> setWall = new HashSet<Map.Type>();
		setWall.add(Map.Type.WALL);

		assertEquals(map.getLoc(new Location(11,1)), setGhost);
		assertEquals(map.getLoc(new Location(1,1)), setPacman);
		assertEquals(map.getLoc(new Location(2,1)), setCookie);
		assertEquals(map.getLoc(new Location(3,2)), setWall);
		assertEquals(map.getLoc(new Location(24,0)), setEmpty);
		assertEquals(map.getLoc(new Location(0,0)), setWall);
	}

}
