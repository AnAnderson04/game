package World;

import java.io.*;
import java.util.HashMap;

public class Room implements Serializable{
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private String name;
	private boolean lock = false;
	private HashMap<String, Item> in = new HashMap<String, Item>();
	private HashMap<String, NPC> npc = new HashMap<String, NPC>();

	
	public Room(String desc, String n) {
		description = desc;
		name = n;
		Game.Rooms.put(desc, this);
	}

	public void addExit(char dir, Room r) {
		if (dir == 'e')
			east = r;
		else if (dir == 'w')
			west = r;
		else if (dir == 'n')
			north = r;
		else if (dir == 's')
			south = r;
		else if (dir == 'u')
			up = r;
		else if (dir == 'd')
			down = r;

	}
	public Room getExit(char dir) {
		if(dir == 'e')
			return east;
		else if(dir == 'w')
			return west;
		else if(dir == 'n')
			return north;
		else if(dir == 's')
			return south;
		else if(dir=='u')
			return up;
		else if(dir=='d')
			return down;
		else
			return null;
	}

	public Item getItem(String name) {
		return in.get(name);
	}

	public void setItem(Item it) {
		in.put(it.getname(), it);
	}

	public String toString() {
		return description;
	}
	
	public void removeItem(String name) {
		in.remove(name);
	}
	
	public boolean lock() {
		return false;
		
	}
	public boolean getlock() {
		return lock;
		
	}
	public void setlock(boolean l) {
		lock = l;
	}
	public String getName () {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public NPC getNPC(String name) {
		return npc.get(name);
	}

	public void setNPC(NPC np) {
		npc.put(np.getName(), np);
	}
}
