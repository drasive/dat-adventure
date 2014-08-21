package com.DimitriVranken.DatAdventure.Locations.Wurzelhausen;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

import static com.DimitriVranken.DatAdventure.DatAdventure.*;

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
