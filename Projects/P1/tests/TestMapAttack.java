import java.awt.Color;
import junit.framework.*;

public class TestMapAttack {

	public void testMapAttack() {
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(5, 5), "name", Color.red);
		PacMan pacman = frame.addPacMan(new Location(1, 1));
		Map map = frame.getMap(); 

		assertTrue(map.isGameOver() == false);

		pacman = frame.addPacMan(new Location(4, 5));

		ghost.attack();

		assertTrue(map.isGameOver() == true);
	}
}
