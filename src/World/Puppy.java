package World;

public class Puppy extends NPC {
	private int i = 1;

	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}

	@Override
	public void talk() { // edit to keep track of which response is needed
		if (i == 1) {
			say("Hi! I'm an adorable puppy!");
			String[] options = { "Yes you are! Who's a good boy?", // 0
					"Ew, no. You're actually kinda hideous." // 1
			};
			getResponse(options);
		} else if (i == 2) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options2 = { "Yes. I love fetch!",
					"No, I'm a horrible person and don't like playing with puppies." };
			getResponse(options2);
		} else {
			String[] options3 = { "Yip!" };
			getResponse(options3);
		}
	}

	@Override
	public void response(int option) {
		if (i == 1) {
			switch (option) {
			case 1:
				say("I am! I'm a good boy!");
				break;
			case 2:
				say("I am adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");
				break;
			}
		}
		// make it advance to the next conversation...
		else if (i == 2) {
			switch (option) {
			case 1:
				say("Yay! Fetch!");
				Game.print("The puppy runs off and returns with a ball. The player receives the ball.");
			case 2:
				say("Yip!");
				Game.print("The dog simply wags his tail.");
				break;
			}
		}
	}
}
