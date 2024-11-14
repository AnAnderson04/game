package World;

public class Chest extends Item{
	public Chest(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
		Item i1 = Game.getItem("key");
		if (i1 != null) {
					Game.print("Using the key, you open the chest! You found a gold coin.");
					Item coin = new Item("This is a coin!", "coin");
					Game.inventory.add(coin);
				}
		else
			Game.print("You need a key to unlock this chest.");
	}
}
