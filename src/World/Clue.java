package World;

public class Clue extends Item{
	public Clue(String name, String desc) {
		super(name, desc);
	}
	
	public void take() {
		String[] words = null;
		Item i = Game.currentRoom.getItem(words[1]);
		Game.print("You picked up " + i.getname());
		Game.inventory.add(i);
	}
}
