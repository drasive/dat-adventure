package com.DimitriVranken.DatAdventure.Routes;

import com.DimitriVranken.DatAdventure.DatAdventure;
import com.DimitriVranken.DatAdventure.NPC;

import static com.DimitriVranken.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DimitriVranken.DatAdventure.DatAdventure.player;

public class Route_OneOOne {

	//Variables
	private static NPC nina = new NPC("route_OneOOne_nina");
	private static NPC leon = new NPC("route_OneOOne_leon");
	private static NPC noriko = new NPC("route_OneOOne_noriko");
	private static NPC roy = new NPC("route_OneOOne_roy");
	private static NPC roland = new NPC("route_OneOOne_roland");
	private static NPC giraffy = new NPC("route_OneOOne_giraffy");

	//Main Methods
	public static void enter() {
		//Enter Location
		DatAdventure.talkLine("\nDu gehst auf die Route 101.");

		if (player.getProgress() < 8) {
			giraffy.talkLine("Du befindest dich auf der Route der 6 Rätsel.");
			giraffy.talkLine("Nur wenn du dein Können unter Beweis stellst lassen wir dich weiter!");
		}

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
				"Nina",
				"Leon",
				"Noriko",
				"Roy",
				"Roland",
				"Giraffy",})) {
				case 1:
					return;
				case 2:
					if (player.getProgress() == 3) {
						ninaPuzzle();           			
					}
					else {
						nina.talkLine("Ich bin 16 Jahre alt.");
					}
					break;
				case 3:
					leon.talkLine("Haio, 9.");
					break;
				case 4:
					if (player.getProgress() < 5) {
						noriko.talkLine("Sprich zuerst mit den anderen.");
					}
					else if (player.getProgress() == 5) {
						norikoPuzzle();
					}
					else {
						noriko.talkLine("Ich bin 42 Jahre alt.");
					}
					break;
				case 5:
					if (player.getProgress() < 4) {
						roy.talkLine("Sprich zuerst mit den anderen.");
					}
					else if (player.getProgress() == 4) {
						royPuzzle();
					}
					else {
						roy.talkLine("Ich bin 12 Jahre alt.");
					}
					break;
				case 6:
					if (player.getProgress() < 6) {
						roland.talkLine("Sprich zuerst mit den anderen.");
					}
					else if (player.getProgress() == 6) {
						rolandPuzzle();
					}
					else {
						roland.talkLine("Ich bin 48 Jahre alt.");
					}
					break;
				case 7:
					if (player.getProgress() < 8) {
						giraffyPuzzle();
					}
					else {
						giraffy.talkLine("Du hast wahrhaftig deine intelligenz bewiesen.");
					}
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Wurzelhausen",
		"Metapolcity"})) {
		case 2:
			player.setLocation(20);
			break;
		case 3:    
			if (player.getProgress() < 8) {
				giraffy.talkLine("Du hast noch nicht alle Rätsel gelöst!");
			}
			else {
				player.setLocation(30);
			}
		}
	}

	//Puzzles
	private static void ninaPuzzle() {
		DatAdventure.outputLine("\n\"/\" eingeben um Gespräch zu beenden");

		while (true) {
			String input = DatAdventure.getStringInput(nina,
					"Vorgestern war Markus noch 15, nächstes Jahr wird er schon 18. Wann hat er Geburtstag (dd.MM)?",
					"Datum", 1, 5);
			if (input.equalsIgnoreCase("/")) {
				break;
			}
			else if (input.equalsIgnoreCase("1.1")) {
				ninaPuzzleSolved();
				break;
			}
			else if (input.equalsIgnoreCase("01.1")) {
				ninaPuzzleSolved();
				break;
			}
			else if (input.equalsIgnoreCase("1.01")) {
				ninaPuzzleSolved();
				break;
			}
			else if (input.equalsIgnoreCase("01.01")) {
				ninaPuzzleSolved();
				break;
			}
			else {
				DatAdventure.outputLine("");
				nina.talkLine("Das ist leider falsch!");
			}
		}
	}

	private static void ninaPuzzleSolved() {
		player.setProgress(4);
		DatAdventure.outputLine("");
		nina.talkLine("Das ist korrekt, du darftst mich ab nun nach meinem Alter fragen!");
	}

	private static void norikoPuzzle() {
		DatAdventure.outputLine("\n\"/\" eingeben um Gespräch zu beenden");

		while (true) {
			String input = DatAdventure.getStringInput(noriko,
					"Ludwig und Klaus haben 20 Euro und sollen diese so unter sich aufteilen, dass Ludwig einen Euro mehr bekommt als Klaus. Wie viel Geld bekommt Ludwig (##.##)?",
					"Mengenangabe", 1, 5);

			if (input.equalsIgnoreCase("/")) {
				break;
			}

            input = input.replace(',', '.');
            if (input.equalsIgnoreCase("10.5")) {
				norikoPuzzleSolved();
				break;
			}
			else if (input.equalsIgnoreCase("10.50")) {
				norikoPuzzleSolved();
				break;
			}
			else {
				DatAdventure.outputLine("");
				noriko.talkLine("Das ist leider falsch!");
			}
		}
	}

	private static void norikoPuzzleSolved() {
		player.setProgress(6);
		DatAdventure.outputLine("");
		noriko.talkLine("Das ist korrekt, du darftst mich ab nun nach meinem Alter fragen!");
	}

	private static void royPuzzle() {
		DatAdventure.outputLine("\n\"/\" eingeben um Gespräch zu beenden");

		while (true) {
			String input = DatAdventure.getStringInput(roy,
					"Harte Schale, leckerer Kern, wer mich knackt, der isst mich gern (Oberbegriff)?",
					"Wort", 1, 10);
			if (input.equalsIgnoreCase("/")) {
				break;
			}
			else if (input.equalsIgnoreCase("Nuss")) {
				royPuzzleSolved();
				break;
			}
			else if (input.equalsIgnoreCase("Nüsse")) {
				royPuzzleSolved();
				break;
			}
			else {
				DatAdventure.outputLine("");
				roy.talkLine("Das ist leider falsch!");
			}
		}
	}

	private static void royPuzzleSolved() {
		player.setProgress(5);
		DatAdventure.outputLine("");
		roy.talkLine("Das ist korrekt, du darftst mich ab nun nach meinem Alter fragen!");
	}

	private static void rolandPuzzle() {
		DatAdventure.outputLine("\n\"/\" eingeben um Gespräch zu beenden");

		while (true) {
			String input = DatAdventure.getStringInput(roland,
					"Was kommt einmal in jeder Minute, zweimal in jedem Moment aber nie in tausend Jahren vor (1 Buchstabe)?",
					"Buchstabe", 1, 1);
			if (input.equalsIgnoreCase("/")) {
				break;
			}
			else if (input.equalsIgnoreCase("M")) {
				rolandPuzzleSolved();
				break;
			}
			else {
				DatAdventure.outputLine("");
				roland.talkLine("Das ist leider falsch!");
			}
		}
	}

	private static void rolandPuzzleSolved() {
		player.setProgress(7);
		DatAdventure.outputLine("");
		roland.talkLine("Das ist korrekt, du darftst mich ab nun nach meinem Alter fragen!");
	}

	private static void giraffyPuzzle() {
		DatAdventure.talkLine("\n\"/\" eingeben um Gespräch zu beenden");

		while (true) {
			String input = DatAdventure.getStringInput(giraffy,
					"Wie alt sind alle Leute ausser mir auf dieser Route zusammen (Jahre)?",
					"Alter", 1, 3);
			if (input.equalsIgnoreCase("/")) {
				break;
			}
			else if (input.equalsIgnoreCase("127")) {
				giraffyPuzzleSolved();
				break;
			}
			else {
				DatAdventure.outputLine("");
				giraffy.talkLine("Das ist leider falsch!");
			}
		}
	}

	private static void giraffyPuzzleSolved() {
		player.setProgress(8);
		DatAdventure.outputLine("");
		giraffy.talkLine("Das ist korrekt, du darfst ab jetzt nach Matepolcity passieren!");
		player.setTask("Erkunde die Route 201");
	}

}
