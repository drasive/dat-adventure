package com.DatAdventure.Locations.Metapolcity;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Metapolcity_HouseOfBrancatos {

	//Variables
	private static NPC rosario = new NPC("metapolcity_houseOfBrancatos_rosario");
	private static NPC laura = new NPC("metapolcity_houseOfBrancatos_laura");
	private static NPC henry = new NPC("metapolcity_houseOfBrancatos_henry");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst ins Haus der Brancatos.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 33);
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
				"Rosario",
				"Laura",
		"Henry"})) {
		case 1:
			return;
		case 2:
			rosario.talkTo();
			break;
		case 3:
			laura.talkTo();
			break;
		case 4:
			henry.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Haus der Brancatos verlassen"})) {
		case 2:
			player.setLocation(30);
		}
	}

}
