package World;

public class Item {
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
}
