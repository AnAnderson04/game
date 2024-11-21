package World;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.HashMap;

public class Game {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap<String, Room> Rooms = new HashMap<String, Room>();// just added, keys are names of Rooms
	static Room currentRoom;

	public static void main(String[] args) {
		runGame();
	}
	
	public static void saveGame(String filename) {
		File f = new File(filename);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(Rooms);
			stream.writeObject(inventory);
			stream.writeObject(currentRoom);
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " +filename+ " not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Bummers, man.");
		}
	}

	public static void loadGame(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			Rooms = (HashMap) stream.readObject();
			currentRoom = (Room) stream.readObject();   
            inventory = (ArrayList<Item>)stream.readObject(); 
			stream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " +fileName+ " not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Bummers, man.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Something went horribly wrong.");
		}
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}

	public static Room getRoom() {
		return currentRoom;
	}

	public static void getText() {
		try {
			Scanner input = new Scanner(new File("poem.txt"));
			while (input.hasNextLine()) {
				Thread.sleep(1000); // sleep for 1 second
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!");
		} catch (InterruptedException ex) {
			System.out.println("Bummer.");
		}
	}

	public static Item getItem(String n) {
		for (int i2 = 0; i2 < inventory.size(); i2++) {
			Item ite = inventory.get(i2);
			if (n.equals(ite.getname())) {
				return ite;
			}
		}
		return null;
	}

	public static void runGame() {
		currentRoom = World.buildWorld();
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
				if (currentRoom.getExit(command.charAt(0)).getlock()) // Work on this
					Game.print("This room is locked.");
				else
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
			case "use":
				Item i3 = currentRoom.getItem(words[1]);
				if (i3 == null) {
					for (int i2 = 0; i2 < inventory.size(); i2++) {
						Item ite = inventory.get(i2);
						if (words[1].equals(ite.getname())) {
							ite.use();
						}
					}
					System.out.println("There is nothing you can use.");
				} else {
					i3.use();
				}
				break;
			case "open":
				Item i4 = currentRoom.getItem(words[1]);
				if (i4 == null) {
					for (int i2 = 0; i2 < inventory.size(); i2++) {
						Item ite = inventory.get(i2);
						if (words[1].equals(ite.getname())) {
							ite.open();
						}
					}
					System.out.println("There is nothing you can open.");
				} else {
					i4.open();
				}
				break;
			case "save":
				saveGame("Save");
				break;
			case "load":
				loadGame("Load");
				break;
			default:
				System.out.println("I don't know what that means.");
			}
		} while (!command.equals("x"));
		input.close();
	}
}