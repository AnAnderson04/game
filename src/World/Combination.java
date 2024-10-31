package World;

public class Combination extends Item{
	public Combination(String name, String desc) {
		super(name, desc);
	}
	
	public void use() {
		Game.print("If you find a safe, try opening it!");	
		}
}
