package com.DimitriVranken.DatAdventure.Locations.Hospital;

import static com.DimitriVranken.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DimitriVranken.DatAdventure.DatAdventure.player;
import static com.DimitriVranken.DatAdventure.DatAdventure.talk;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

public class Hospital_DischargeStation {

	//Variables
	private static NPC youngGirl = new NPC("hospital_dischargeStation_youngGirl");
	private static NPC doctorsAssistant = new NPC("hospital_dischargeStation_doctorsAssistant");
	private static NPC nurse = new NPC("hospital_dischargeStation_nurse");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst zur Abgabe.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 12);
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
				"Kleines Mädchen",
				"Assistenzarzt",
		"Krankenschwester"})) {
		case 1:
			return;
		case 2:
			youngGirl.talkTo();
			break;
		case 3:
			doctorsAssistant.talkTo();
			break;
		case 4:
			if (player.getProgress() == 1) {
				nurse.talkLine("Hier hast du deine Sachen, dein Vater wartet draussen auf dich.");
				player.setProgress(2);
			}
			else {
				nurse.talkTo();
			}            	
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Krankenhaus verlassen",
				"Zimmer",
		"Büro des Chefarztes"})) {
		case 2:
			com.DimitriVranken.DatAdventure.Locations.Hospital.Hospital.outputLocationsToGo();
			break;
		case 3:
			player.setLocation(11);
			break;
		case 4:
			player.setLocation(13);
		}
	}

}
