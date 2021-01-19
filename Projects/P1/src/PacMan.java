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
		// et locations in all 4 directions
		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);
		Location upRight = new Location(x + 1, y - 1);
		Location upLeft = new Location(x - 1, y - 1);
		Location downRight = new Location(x + 1, y + 1);
		Location downLeft = new Location(x - 1, y + 1);

		// .toString().compareTo("[WALL]") != 0
 		if (myMap.getLoc(right) != null && !myMap.getLoc(right).contains(Map.Type.GHOST) && !myMap.getLoc(right).contains(Map.Type.WALL) && !arr.contains(right))
 			arr.add(right);

		if (myMap.getLoc(left) != null && !myMap.getLoc(left).contains(Map.Type.GHOST) && !myMap.getLoc(left).contains(Map.Type.WALL) && !arr.contains(left))
			arr.add(left);

		if (myMap.getLoc(up) != null && !myMap.getLoc(up).contains(Map.Type.GHOST) && !myMap.getLoc(up).contains(Map.Type.WALL) && !arr.contains(up))
			arr.add(up);

		if (myMap.getLoc(down) != null && !myMap.getLoc(down).contains(Map.Type.GHOST) && !myMap.getLoc(down).contains(Map.Type.WALL) && !arr.contains(down))
			arr.add(down);

		if (myMap.getLoc(upRight) != null && !myMap.getLoc(upRight).contains(Map.Type.GHOST) && !myMap.getLoc(upRight).contains(Map.Type.WALL) && !arr.contains(upRight))
			arr.add(upRight);

		if (myMap.getLoc(upLeft) != null && !myMap.getLoc(upLeft).contains(Map.Type.GHOST) && !myMap.getLoc(upLeft).contains(Map.Type.WALL) && !arr.contains(upLeft))
			arr.add(upLeft);

		if (myMap.getLoc(downRight) != null && !myMap.getLoc(downRight).contains(Map.Type.GHOST) && !myMap.getLoc(downRight).contains(Map.Type.WALL) && !arr.contains(downRight))
			arr.add(downRight);

		if (myMap.getLoc(downLeft) != null && !myMap.getLoc(downLeft).contains(Map.Type.GHOST) && !myMap.getLoc(downLeft).contains(Map.Type.WALL) && !arr.contains(downLeft))
			arr.add(downLeft);

		return arr;
	}


	public boolean move() {
		ArrayList<Location> valid_moves = new ArrayList<Location>();
		valid_moves = get_valid_moves();
		if(valid_moves.size() == 0)
			return false;
		Random r = new Random();
		this.myLoc = valid_moves.get(r.nextInt(valid_moves.size()));
		return myMap.move(myName, myLoc, Map.Type.PACMAN);
	}

	public boolean is_ghost_in_range() { 
		int x = this.myLoc.x;
		int y = this.myLoc.y;

		Location right = new Location(x + 1, y);
		Location left = new Location(x - 1, y);
		Location up = new Location(x, y - 1);
		Location down = new Location(x, y + 1);
		
		if (myMap.getLoc(right).contains(Map.Type.GHOST)) {
			return true;
		}
		if (myMap.getLoc(left).contains(Map.Type.GHOST)) {
			return true;
		}
		if (myMap.getLoc(up).contains(Map.Type.GHOST)) {
			return true;
		}
		if (myMap.getLoc(down).contains(Map.Type.GHOST)) {
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
