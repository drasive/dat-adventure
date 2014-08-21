package com.DimitriVranken.DatAdventure.Routes;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

import static com.DimitriVranken.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DimitriVranken.DatAdventure.DatAdventure.player;

public class Route_TwoOOne {

	//Variables
	private static NPC dimitri = new NPC("route_TwoOOne_dimitri");

	//Main Methods
	public static void enter() {
		//Enter Location
		DatAdventure.talkLine("\nDu gehst auf die Route 201.");

		//Run Location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 101);
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
		"Dimitri"})) {
		case 1:
			return;
		case 2:
			dimitri.talkTo();
			player.setProgress(12);
            DatAdventure.outputLine("\nGib \"/reset\" ein, um deinen Spielstand zurückzusetzen und von vorne zu beginnen.");
        }
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
		"Metapolcity"})) {
		case 2:
			player.setLocation(30);
		}
	}

}
