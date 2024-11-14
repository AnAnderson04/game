package World;

public class Key extends Item{
	public Key(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
			Game.print("You unlocked " + Game.getRoom().getExit('w'));
			Game.getRoom().setlock(false);
		}
}
