import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

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
		int x = this.myLoc.x;
		int y = this.myLoc.y;
		ArrayList<Location> arr = new ArrayList<Location>();

		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);

		// .toString().compareTo("[WALL]") != 0
		if (!myMap.getLoc(right).contains(Map.Type.WALL))
			arr.add(right);

		if (!myMap.getLoc(left).contains(Map.Type.WALL))
			arr.add(left);

		if (!myMap.getLoc(up).contains(Map.Type.WALL))
			arr.add(up);

		if (!myMap.getLoc(down).contains(Map.Type.WALL))
			arr.add(down);

		return arr;
	}

	public boolean move() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		valid_moves = get_valid_moves();

		Random r = new Random();
		this.myLoc = valid_moves.get(r.nextInt(valid_moves.size()));
				
		return true;
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
		if (is_pacman_in_range()) {
			return this.myMap.attack(this.myName);
		}
		return false;
	}
}
