package World;

public class Mom extends NPC {
	public Mom() {
		super("Mom", "Your mom is sitting and reading a book...");
	}

	@Override
	public void talk() { //edit to make it the same as the puppy class
		say("Good morning, sleepy head!");
		String[] options = { "Morning, mom.", "Don't insult me, mom." };
		getResponse(options);
	}

	@Override
	public void response(int option) {
		switch (option) {
		case 1:
			say("Did you sleep well?");
			break;
		case 2:
			say("Fine then...");
			Game.print("Mom ignores you for the rest of the day.");
			break;
		case 3:
			say("Have a great day!");
			Game.print("Mom goes back to reading her book.");
			break;
		}
	}
}
