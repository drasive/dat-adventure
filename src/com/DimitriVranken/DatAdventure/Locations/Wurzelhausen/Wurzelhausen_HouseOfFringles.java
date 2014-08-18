package com.DimitriVranken.DatAdventure.Locations.Wurzelhausen;

import static com.DimitriVranken.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DimitriVranken.DatAdventure.DatAdventure.player;
import static com.DimitriVranken.DatAdventure.DatAdventure.talk;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

public class Wurzelhausen_HouseOfFringles {

	//Variables
	private static NPC dominik = new NPC("wurzelhausen_houseOfFringles_dominik");
	private static NPC pascal = new NPC("wurzelhausen_houseOfFringles_pascal");
	private static NPC annelise = new NPC("wurzelhausen_houseOfFringles_annelise");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst ins Haus der Fringles.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 23);
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
				"Dominik",
				"Pascal",
		"Annelise"})) {
		case 1:
			return;
		case 2:
			dominik.talkTo();
			break;
		case 3:
			pascal.talkTo();
			break;
		case 4:
			annelise.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Haus der Fringles verlassen"})) {
		case 2:
			player.setLocation(20);
		}
	}

}
