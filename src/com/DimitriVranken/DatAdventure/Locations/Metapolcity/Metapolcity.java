package com.DatAdventure.Locations.Metapolcity;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;

public class Metapolcity {

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst nach Metapolcity.");

		//Run Location-loop
		do  {
			outputChangeLocation();
		} while (player.getLocation() == 30);
	}

	//Output Methods
	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Metapolcity verlassen",
				"Dorfladen",
				"Haus der Bischops",
				"Haus der Brancatos",
		"Arena"})) {
		case 1:
			outputLocationsToGo();
			break;
		case 2:
			player.setLocation(31);
			break;
		case 3:
			player.setLocation(32);
			break;
		case 4:
			player.setLocation(33);
			break;
		case 5:
			player.setLocation(34);
		}
	}

	private static void outputLocationsToGo() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Route 101",
		"Route 201"})) {
		case 2:
			player.setLocation(101);
			break;
		case 3:
			if (player.getProgress() == 8) {
				DatAdventure.talkLine("Das Tor zu Route 201 ist verschlossen, es lässt sich nur mit einem Schlüssel öffnen!");
				player.setProgress(9);
				player.setTask("Finde den Schlüssel für das Tor zu Route 201.");
			}
			else if (player.getProgress() < 10) {
				DatAdventure.talkLine("Das Tor zu Route 201 ist verschlossen, es lässt sich nur mit einem Schlüssel öffnen!");
			}
			else if (player.getProgress() == 10) {
				player.setProgress(11);
				DatAdventure.talkLine("Das benutzt den Schlüssel von Quadrocoptulus um das Tor aufzuschliessen!");
				player.setLocation(201);
			}
			else {
				player.setLocation(201);
			}
		}
	}

}
