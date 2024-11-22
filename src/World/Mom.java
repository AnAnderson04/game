package World;

public class Mom extends NPC {
	private int i = 1;

	public Mom() {
		super("Mom", "Your mom is sitting and reading a book...");
	}

	@Override
	public void talk() { // edit to make it the same as the puppy class
		if (i == 1) {
			say("Mom seems to be reading her favorite book.");
			String[] options = { "Morning, Mom.", // 0
					"Mom, pay attention!" // 1
			};
			getResponse(options);
		} else if (i == 2) {
			say("Did you sleep well last night?");
			String[] options2 = { "I slept fine...", 
					"No way!" 
					};
			getResponse(options2);
		} else {
			String[] options3 = { "Still reading here, sweetie..." };
			getResponse(options3);
		}
	}

	@Override
	//fix responses
	public void response(int option) {
		if(i == 1) {
			switch (option) {
			case 1:
				say("Good morning!");
			break;
			case 2:
				say("How rude...");
				Game.print("Mom ignores you for the rest of the day.");
			break;
			}
		}
		if(i == 2) {
			switch (option) {
			case 1:
				say("That's wonderful.");
			break;
			case 2:
				say("That's a shame.");
				Game.print("Mom goes back to reading her book.");
			}
		
		}
		i++;
	}
}
