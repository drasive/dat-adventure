package com.DimitriVranken.DatAdventure.Locations.Hospital;

import static com.DimitriVranken.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DimitriVranken.DatAdventure.DatAdventure.player;
import static com.DimitriVranken.DatAdventure.DatAdventure.talk;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

public class Hospital_OfficeOfHeadPhysician {

	//Variables
	private static NPC headPhysician = new NPC("hospital_officeOfHeadPhysician_headPhysician");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst ins Büro des Chefarztes.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 13);
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
		"Chefarzt"})) {
		case 1:
			return;
		case 2:
			headPhysician.talkTo();
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Krankenhaus verlassen",
				"Zimmer",
		"Abgabe"})) {
		case 2:
			com.DimitriVranken.DatAdventure.Locations.Hospital.Hospital.outputLocationsToGo();
			break;
		case 3:
			player.setLocation(11);
			break;
		case 4:
			player.setLocation(12);
		}
	}

}
