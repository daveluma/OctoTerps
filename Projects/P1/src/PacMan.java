import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		int x = this.myLoc.x;
		int y = this.myLoc.y;

		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);
		
		if (myMap.getLoc(right).toString().equals("[GHOST]")) {
			return true;
		}
		if (myMap.getLoc(left).toString().equals("[GHOST]")) {
			return true;
		}
		if (myMap.getLoc(up).toString().equals("[GHOST]")) {
			return true;
		}
		if (myMap.getLoc(down).toString().equals("[GHOST]")) {
			return true;
		}

		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
