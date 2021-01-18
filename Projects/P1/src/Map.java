import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location

		Location prev_loc = locations.replace(name, loc);
		JComponent comp = components.get(name);


		if (prev_loc == null || comp == null) return false;
		
		comp.setLocation(loc.x, loc.y);
		components.replace(name, comp);
		
		return false;
	}
	
	public HashSet<Type> getLoc(Location loc) {
		if (!field.containsKey(loc))
			return emptySet;
		else if (field.get(loc).contains(Type.WALL))
			return wallSet;	
		return field.get(loc);
	}

	public boolean attack(String Name) {
		return true;
	}
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		this.cookies++;
		Location loc = this.locations.get(name);
		JComponent comp = this.components.get(name);
		this.field.get(loc).remove(Type.COOKIE);

		return comp;
	}
}
