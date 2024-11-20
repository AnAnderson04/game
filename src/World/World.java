package World;

public class World {
	public static Room buildWorld() {
		Room bedroom = new Room( "Bedroom" ,"You are in your Bedroom.");
		Room bathroom = new Room("Bathroom" ,"You are in the bathroom.");
		Room hallway = new Room("Hallway" ,"You are in the hallway.");
		Room attic = new Room("Attic", "You are in the attic.");
		Room livingroom = new Room("Living Room", "You are in the living room.");
		Room kitchen = new Room("Kitchen", "You are in the kitchen.");
		
		bedroom.addExit('e', hallway);
		hallway.addExit('w', bedroom);
		bedroom.addExit('w', bathroom);
		bathroom.addExit('e', bedroom);
		hallway.addExit('u', attic);
		hallway.addExit('d', livingroom);
		attic.addExit('d', hallway);
		livingroom.addExit('u', hallway);
		livingroom.addExit('w', kitchen);
		
		Key key = new Key("This is a key.", "key");
		livingroom.setItem(key);
		Item phone = new Item("This is a phone.", "phone");
		bedroom.setItem(phone);
		Item sandwich = new Item("This is a sandwich.", "sandwich");
		kitchen.setItem(sandwich);
		Item mirror = new Item("This is a mirror.", "mirror");
		bathroom.setItem(mirror);
		Item book = new Item("This is a book.", "book");
		bedroom.setItem(book);
		Item flashlight = new Item("This is a flashlight.", "flashlight");
		bedroom.setItem(flashlight);
		Combination combination = new Combination("This is a combination.", "combination");
		hallway.setItem(combination);
		Safe safe = new Safe("It's an impressive safe!", "safe");
		attic.setItem(safe);
		
		//creating three more items
		Chest chest = new Chest("This is a chest.", "chest");
		attic.setItem(chest);
		Clue clue = new Clue("Go above to find a great prize!", "clue");
		hallway.setItem(clue);
		Photo photo = new Photo("A photo that shows something shiny...", "photo");
		kitchen.setItem(photo);
		
		//locking a room
		bathroom.setlock(true);
		
		return bedroom;
	}
}
