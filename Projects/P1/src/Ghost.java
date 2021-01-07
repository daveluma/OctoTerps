import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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

	public boolean is_pacman_in_range() { 
		int x = this.myLoc.x;
		int y = this.myLoc.y;

		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);
		
		if (myMap.getLoc(right).toString().contains("PACMAN")) {
			return true;
		}
		if (myMap.getLoc(left).toString().contains("PACMAN")) {
			return true;
		}
		if (myMap.getLoc(up).toString().contains("PACMAN")) {
			return true;
		}
		if (myMap.getLoc(down).toString().contains("PACMAN")) {
			return true;
		}

		return false;
	}

	public boolean attack() {
		return false;
	}
}
