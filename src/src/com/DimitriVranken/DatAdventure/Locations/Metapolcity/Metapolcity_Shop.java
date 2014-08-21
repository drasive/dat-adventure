package com.DimitriVranken.DatAdventure.Locations.Metapolcity;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

import static com.DimitriVranken.DatAdventure.DatAdventure.*;

public class Metapolcity_Shop {

	//Variables
	private static NPC employee = new NPC("metapolcity_shop_employee");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst in den Dorfladen.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 31);
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
		"Angestellte"})) {
		case 1:
			return;
		case 2:
			employee.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Dorfladen verlassen"})) {
		case 2:
			player.setLocation(30);
		}
	}

}
