package com.DimitriVranken.DatAdventure.Locations.Hospital;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

import static com.DimitriVranken.DatAdventure.DatAdventure.*;

public class Hospital {

	//Variables
	private static NPC father = new NPC("hospital_room_father");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu betrittst das Krankenhaus.");

		//Run Location-loop
		do  {
			outputChangeLocation();
		} while (player.getLocation() == 10);
	}

	//Output Methods
	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] { "Krankenhaus verlassen",
				"Zimmer",
				"Abgabe",
		"Büro des Chefarztes"})) {
		case 1:
			outputLocationsToGo();
			break;
		case 2:
			player.setLocation(11);
			break;
		case 3:
			player.setLocation(12);
			break;
		case 4:
			player.setLocation(13);
		}
	}

	static void outputLocationsToGo() {
		if (player.getProgress() < 2) {
			DatAdventure.talkLine("");
			father.talkLine("Hohl noch deine Sachen ab, dann können wir gehen.");
		}
		else if (player.getProgress() == 2) {
			DatAdventure.talkLine("");
			father.talkLine("Hei, da bist du ja endlich.");
			father.talkLine("Komm, ich fahr dich nach Hause.");
			player.setProgress(3);
			player.setLocation(22);
			DatAdventure.outputNextDay();
			player.setTask("Erkunde die Umgebung.");
		}
		else {
			switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
			"Wurzelhausen"})) {
			case 2:
				player.setLocation(20);
			}
		}
	}

}
