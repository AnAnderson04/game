package World;

import java.io.*;

public class Item implements Serializable{
	private String description;
	private String name;
	
	public Item(String desc, String n) {
		description = desc;
		name = n;
	}
	public String getdesc() {
		return description;
	}
	public String getname() {
		return name;
	}
	public void setdesc(String desc) {
		description = desc;
	}
	public void setname(String n) {
		name = n;
	}
	public String toString() {
		return name;
	}
	public void use() {
		Game.print("You can't use that!");
	}
	public void open() {
		Game.print("You can't open that!");
	}
}
