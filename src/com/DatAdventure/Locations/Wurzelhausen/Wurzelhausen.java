package com.DatAdventure.Locations.Wurzelhausen;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

public class Wurzelhausen {

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst nach Wurzelhausen.");

		//Run Location-loop
		do  {
			outputChangeLocation();
		} while (player.getLocation() == 20);
	}

	//Output Methods
	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Wurzelhausen verlassen",
				"Dorfladen",
				"Zu Hause",
				"Haus der Fringelis",
		"Labor"})) {
		case 1:
			outputLocationsToGo();
			break;
		case 2:
			player.setLocation(21);
			break;
		case 3:
			player.setLocation(22);
			break;
		case 4:
			player.setLocation(23);
			break;
		case 5:
			player.setLocation(24);
		}
	}

	private static void outputLocationsToGo() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Krankenhaus",
		"Route 101"})) {
		case 2:
			player.setLocation(10);
			break;
		case 3:
			player.setLocation(101);
		}
	}

}
