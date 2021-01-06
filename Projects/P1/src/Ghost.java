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
		return null;
	}

	public boolean move() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		valid_moves = get_valid_moves();

		Random r = new Random();
		try {
			this.myLoc = valid_moves.get(r.nextInt(valid_moves.size()));
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
