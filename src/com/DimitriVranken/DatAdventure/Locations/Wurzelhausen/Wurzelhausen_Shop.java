package com.DatAdventure.Locations.Wurzelhausen;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Wurzelhausen_Shop {

	//Variables
	private static NPC employee = new NPC("wurzelhausen_shop_employee");
	private static NPC pokemonTrainer = new NPC("wurzelhausen_shop_man");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst in den Dorfladen.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 21);
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
				"Angestellte",
		"Mann"})) {
		case 1:
			return;
		case 2:
			employee.talkTo();
			break;
		case 3:
			pokemonTrainer.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Dorfladen verlassen"})) {
		case 2:
			player.setLocation(20);
		}
	}

}
