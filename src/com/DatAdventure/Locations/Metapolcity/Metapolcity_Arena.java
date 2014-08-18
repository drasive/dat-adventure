package com.DatAdventure.Locations.Metapolcity;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talk;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Metapolcity_Arena {

	//not implemented

	//Variables
	private static NPC optimusPrime = new NPC("metapolcity_arena_optimusPrime");
	private static NPC quadrocoptulus = new NPC("metapolcity_arena_quadrocoptulus");
	private static NPC nina = new NPC("metapolcity_arena_nina");

	//Main Methods
	public static void enter() {
		//Enter Location
		talk("\nDu gehst in die Arena.");

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
				"Optimus Prime",
				"Quadrocoptulus",
				"Nina"})) {
		case 1:
			return;
		case 2:
			if (player.getProgress() == 12) {
				optimusPrime.talkLine("...keuch ..");
			}
			else {
				optimusPrime.talkTo();
			}            	
			break;
		case 3:
			if (player.getProgress() < 10) {
				player.setProgress(10);
				quadrocoptulus.talkLine("Hier kleiner, halt kurz meine Schlüssel, Optimus Prime mach ich platt!");
				player.setTask("Benutze den Schlüssel von Quadrocoptulus am Tor zu Route 201.");
			}
			else if (player.getProgress() == 12) {
				player.setProgress(0);
				player.setLocation(11);
				quadrocoptulus.talkLine("Du hast meine Schlüssel geklaut! Dafür wirst du büssen, genauso wie Optimus Prime!", 1500);
				DatAdventure.talkLine("Krach!", 1800);
				DatAdventure.talkLine("B..umm!", 2400);
				DatAdventure.talkLine(".. äc .h.z\n\n", 3000);
				DatAdventure.talk(".", 2200);
				DatAdventure.talk(".", 2200);
				DatAdventure.talk(".", 5000);
				DatAdventure.talkLine("\n\n", 0);
			}
			else {
				quadrocoptulus.talkTo();
			}
			break;
		case 4:
			nina.talkTo();
		}
		if (player.getProgress() != 0) {
			outputTalkToPerson();	
		}
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Arena verlassen"})) {
		case 2:
			player.setLocation(30);
		}
	}

}
