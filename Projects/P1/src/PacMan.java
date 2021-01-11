import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

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
		int x = this.myLoc.x;
		int y = this.myLoc.y;
		// x=1, y=1

		ArrayList<Location> arr = new ArrayList<Location>();
		//set locations in all 4 directions
		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);

		// .toString().compareTo("[WALL]") != 0
		if (myMap.getLoc(right) != null && !myMap.getLoc(right).contains(Map.Type.WALL))
			arr.add(right);

		if (myMap.getLoc(left) != null && !myMap.getLoc(left).contains(Map.Type.WALL))
			arr.add(left);

		if (myMap.getLoc(up) != null && !myMap.getLoc(up).contains(Map.Type.WALL))
			arr.add(up);

		if (myMap.getLoc(down) != null && !myMap.getLoc(down).contains(Map.Type.WALL))
			arr.add(down);

		return arr;			
	}

	public boolean move() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		valid_moves = get_valid_moves();

		Random r = new Random();
		this.myLoc = valid_moves.get(r.nextInt(valid_moves.size()));
		myMap.move(myName, myLoc, Map.Type.PACMAN);

		return true;
	}

	public boolean is_ghost_in_range() { 
		int x = this.myLoc.x;
		int y = this.myLoc.y;

		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);
		
		if (myMap.getLoc(right) != null && myMap.getLoc(right).toString().contains("GHOST")) {
			return true;
		}
		if (myMap.getLoc(left) != null && myMap.getLoc(left).toString().contains("GHOST")) {
			return true;
		}
		if (myMap.getLoc(up) != null && myMap.getLoc(up).toString().contains("GHOST")) {
			return true;
		}
		if (myMap.getLoc(down) != null && myMap.getLoc(down).toString().contains("GHOST")) {
			return true;
		}

		return false;
	}

	public JComponent consume() { 
		if (this.myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE)) {	
			return this.myMap.eatCookie(String.format("tok_x%s_y%s", this.myLoc.x, this.myLoc.y));	
		}
 		return null;
	}
}
