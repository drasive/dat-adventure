package com.DatAdventure.Locations.Wurzelhausen;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Wurzelhausen_Laboratory {

	//Variables
	private static NPC father = new NPC("wurzelhausen_laboratory_father");
	private static NPC labAssistant = new NPC("wurzelhausen_laboratory_labAssistant");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst ins Labor.");

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
				"Vater",
		"Laborant"})) {
		case 1:
			return;
		case 2:
			father.talkTo();
			break;
		case 3:
			labAssistant.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Labor verlassen"})) {
		case 2:
			player.setLocation(20);
		}
	}

}