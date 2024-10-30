package World;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Game {
	static ArrayList<Item> inventory = new ArrayList<Item>();
	public static void main(String[] args) {
		runGame();
	}
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);

		String command;
		do {
			System.out.println(currentRoom);
			System.out.println("What do you want to do?");
			command = input.nextLine();
			String[] words = command.split(" ");
			switch (words[0]) {
			case "e":
			case "n":
			case "s":
			case "w":
			case "u":
			case "d":
				currentRoom = currentRoom.getExit(command.charAt(0));
				break;
			case "x":
				System.out.println("Thanks for walking through my game!");
				break;
			case "take":
				Item i = currentRoom.getItem(words[1]);
				if (i == null)
					System.out.println("There's nothing to take here.");
				else {
					inventory.add(i);
					System.out.println("You picked up " + i.getname());
				}
				break;
			case "look":
				Item i1 = currentRoom.getItem(words[1]);
				if (i1 == null) {
					for (int i2 = 0; i2 < inventory.size(); i2++) {
						Item ite = inventory.get(i2);
						if (words[1].equals(ite.getname())) {
							System.out.println(ite.getdesc());
						}
					}
					System.out.println("There is no such item in room or inventory.");
				} else {
					System.out.println(i1.getdesc());
				}
				break;
			case "i":
				System.out.println("You are carrying: ");
				for (Item it : inventory)
					System.out.println(it);
				break;
			default:
				System.out.println("I don't know what that means.");
			}
		} while (!command.equals("x"));
		input.close();
	}
}