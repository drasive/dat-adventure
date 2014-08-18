package com.DatAdventure.Locations.Metapolcity;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Metapolcity_HouseOfBischops {

	//Variables
	private static NPC nicola = new NPC("metapolcity_houseOfBischops_nicola");
	private static NPC alfred = new NPC("metapolcity_houseOfBischops_alfred");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst ins Haus der Bischops.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 32);
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
				"Nicola",
		"Alfred"})) {
		case 1:
			return;
		case 2:
			nicola.talkTo();
			break;
		case 3:
			alfred.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Haus der Bischops verlassen"})) {
		case 2:
			player.setLocation(30);
		}
	}

}
