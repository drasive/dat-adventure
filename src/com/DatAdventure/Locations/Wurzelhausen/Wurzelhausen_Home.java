package com.DatAdventure.Locations.Wurzelhausen;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Wurzelhausen_Home {

	//Variables
	private static NPC mother = new NPC("wurzelhausen_home_mother");
	private static NPC sister = new NPC("wurzelhausen_home_sister");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst nach Hause.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 22);
	}

	//Output Methods
	public static void outputMenu() {
		switch (getMenuItemChoice("Was möchtest du tun?", new String[] {"Mit Person sprechen",
				"Ort wechseln (" + DatAdventure.convertLocationToString(player.getLocation()) + ")"})) {
				case 1:
					outputTalkToPerson();
					break;
				case 2:
					outputChangeLocation();
		}
	}

	private static void outputTalkToPerson() {
		switch (getMenuItemChoice("Mit wem möchtest du sprechen?", new String[] {"Zurück zum Menu",
				"Mutter",
		"Schwester"})) {
		case 1:
			return;
		case 2:
			mother.talkTo();
			break;
		case 3:
			sister.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Haus verlassen"})) {
		case 2:
			player.setLocation(20);
		}
	}

}
