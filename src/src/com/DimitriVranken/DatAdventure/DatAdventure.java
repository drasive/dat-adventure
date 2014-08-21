package com.DimitriVranken.DatAdventure;

import com.DimitriVranken.DatAdventure.DataAccess.DataFile;
import com.DimitriVranken.DatAdventure.DataAccess.ManagedProperties;
import com.DimitriVranken.DatAdventure.Locations.Hospital.*;
import com.DimitriVranken.DatAdventure.Locations.Metapolcity.*;
import com.DimitriVranken.DatAdventure.Locations.Wurzelhausen.*;
import com.DimitriVranken.DatAdventure.Routes.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DatAdventure {

	// Variables
	public static Player player = new Player();
	private static Scanner scanner = new Scanner(System.in);

    private static String[] args;
    private static ManagedProperties applicationProperties = new ManagedProperties(DataFile.Application);

	// Main
	public static void main(String[] args) {
        DatAdventure.args = args;

		outputGameTitle();

        if (player.getProgress() == -1) {
            player.setLocation(11);
        }
		else if (player.getProgress() > 0) {
			player.outputInformation();
		}

		while (true) {  // Game loop
			switch (player.getLocation()) {
			case 10:
				Hospital.enter();
			case 11:
				Hospital_Room.enter();
				break;
			case 12:
				Hospital_DischargeStation.enter();
				break;
			case 13:
				Hospital_OfficeOfHeadPhysician.enter();
				break;
			case 20:
				Wurzelhausen.enter();
				break;
			case 21:
				Wurzelhausen_Shop.enter();
				break;
			case 22:
				Wurzelhausen_Home.enter();
				break;
			case 23:
				Wurzelhausen_HouseOfFringles.enter();
				break;
			case 24:
				Wurzelhausen_Laboratory.enter();
				break;
			case 30:
				Metapolcity.enter();
				break;
			case 31:
				Metapolcity_Shop.enter();
				break;
			case 32:
				Metapolcity_HouseOfBischops.enter();
				break;
			case 33:
				Metapolcity_HouseOfBrancatos.enter();
				break;
			case 34:
				Metapolcity_Arena.enter();
				break;
			case 101:
				Route_OneOOne.enter();
				break;
			case 201:
				Route_TwoOOne.enter();
				break;
			default:
				outputError("Unbekannter Ort!");
			}
		}
	}

	// Output
	private static void outputGameTitle() {
		System.out.println("----- Dat Adventure -----" +
				"\n\nViel Spass!" +
				"\nGib \"/help\" ein, um die Hilfe zu öffnen." +
                "\nGib \"/walkthrough\" ein, um die Komplettlösung zu öffnen." +
                "\nGib \"/reset\" ein, um den Spielstand zurückzusetzen." +
				"\n\n-----------------------" +
				"\n");
	}

	public static void outputError(String text) {
		System.err.println("\n" + text +
				"\nProgramm wird beendet!");
		System.exit(1);
	}

	public static void talkLine(String text) {
		talkLine(text, 200);
	}

	public static void talkLine(String text, long wait) {
		talk(text + "\n", wait);
	}

	public static void talk(String text) {
		talk(text, 200);
	}

	public static void talk(String text, long wait) {
		for (int charPosition = 0; charPosition < text.length(); charPosition++) { // Iterate through chars of text
			System.out.print(text.charAt(charPosition)); // Write single char

            // Wait
            int character_delay = applicationProperties.getInteger("output_character_delay", 50);
			sleep(character_delay);
		}
		sleep(wait);
	}

	public static void outputLine(String text) {
		output(text  + "\n");
	}

	public static void output(String text) {
		System.out.print(text);
	}

	public static void outputNextDay() {
		talkLine("\n...\nAm nächsten Tag\n");
	}

	// Input
	public static int getMenuItemChoice(String text, String menuItems[]) {
		String outputText = "\n";
		for (int menuItemPosition = 0; menuItemPosition < menuItems.length; menuItemPosition++) { // Iterate through menu items
			outputText += (menuItemPosition + 1) + " - " + menuItems[menuItemPosition]; // Add "[number] - [menu item]" to output string
			if (menuItemPosition < menuItems.length - 1) {  // Add line break if the current is not the last menu item
				outputText += "\n";
			}
		}
		outputLine(outputText);

		return getIntegerInput(text, 1, menuItems.length);
	}

	public static String getStringInput(NPC npc, String text, String value, int minLength, int maxLength) {
		while (true) { // Repeat till valid result is returned
			if (npc == null) {  // Just talk
				talk(text + " ");
			}
			else {  // Talk through npc
				npc.talk(text + " ");
			}

			String input = scanner.next();
            if (checkForCommand(input)) {
                // do nothing
            }
			else if (input.length() < minLength) {
				talkLine("Diese(s/r) " + value + " ist etwas kurz (Mindestens " + minLength + " Zeichen)!");
			} else if (input.length() > maxLength) {
				talkLine("Diese(s/r) " + value + " ist etwas lang (Maximal " + maxLength + " Zeichen)!");
			} else {
				sleep(200);
				return input;
			}
		}
	}

	public static int getIntegerInput(String text, int minValue, int maxValue) {
		while (true) { // Repeat till valid result is returned
			talk(text + " ");

			String stringInput = scanner.next();
            if (checkForCommand(stringInput)) {
                // do nothing
            }
			else if (isInteger(stringInput)) { // check for non-numeric parts
				int integerInput = Integer.parseInt(stringInput);
				if (integerInput < minValue) {
					talkLine("Die eingegebene Zahl ist zu klein!");
				}
				else if (integerInput > maxValue) {
					talkLine("Die eingegebene Zahl ist zu gross!");
				}
				else {
					return integerInput;
				}
			}
		}
	}

	public static Boolean getBooleanInput() {
		while (true) { // Repeat till valid result is returned
			String input = scanner.next();
			if (checkForCommand(input)) {
                // do nothing
            }
			else {
				if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) { // return true if "y" or "yes"
					return true;
				}
				else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) { // return false if "n" or "no"
					return false;
				}
			}
			talk("y/n? "); // Output possible answers
		}
	}


    private static boolean checkForCommand(String input) {
        if (input.equalsIgnoreCase("/help")) {
            openHelp();
            return true;
        }
        else if (input.equalsIgnoreCase("/walkthrough")) {
            openWalkthrough();
            return true;
        }
        else if (input.equalsIgnoreCase("/reset")) {
            checkResetSavegame();
            return true;
        }

        return false;
    }

	// Helpers
	private static void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException ex) {
			outputError("Verzögerte Textausgabe nicht möglich!");
		}
	}

	public static String convertLocationToString(int location) {
		switch(location) {
		case 10:
			return "Krankenhaus";
		case 11:
			return "Krankenhaus, Zimmer";
		case 12:
			return "Krankenhaus, Abgabe";
		case 13:
			return "Krankenhaus, Büro des Oberarztes";
		case 20:
			return "Wurzelhausen";
		case 21:
			return "Wurzelhausen, Pokecenter";
		case 22:
			return "Wurzelhausen, Zu Hause";
		case 23:
			return "Wurzelhausen, Haus der Fringles";
		case 24:
			return "Wurzelhausen, Labor";
		case 30:
			return "Metapolcity";
		case 31:
			return "Metapolcity, Shop";
		case 32:
			return "Metapolcity, Haus der Bischops";
		case 33:
			return "Metapolcity, Haus der Brancatos";
		case 34:
			return "Metapolcity, Arena";
		case 101:
			return "Route 101";
		case 201:
			return "Route 201";
		default:
			return null;
		}
	}

	public static Boolean isInteger(String text) {
		try {
			Integer.parseInt(text);
		} catch(NumberFormatException ex) {
			return false; // return false if parsing failed
		}
		return true; // return true if parsing was successful
	}


    private static void checkResetSavegame() {
        DatAdventure.talk("Bist du sicher, dass du den aktuellen Spielstand löschen und das Spiel neu beginnen möchtest?" + " (y/n): ");
        if (DatAdventure.getBooleanInput()) {
            player.setProgress(-1);
            DatAdventure.talkLine("Spielstand zurückgesetzt!\n\n\n", 500);

            restart();
        }
    }

    private static void restart() {
        main(args);
    }


    private static void openHelp() {
        if (!openFile("../docs/Dat Adventure.pdf")) {
            System.err.println("Fehler beim öffnen der Hilfe!");
        }
    }

    private static void openWalkthrough() {
        if (!openFile("../docs/Walkthrough.pdf")) {
            System.err.println("Fehler beim öffnen der Komplettlösung!");
        }
    }


    private static boolean doesFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    private static boolean openFile(String filePath) {
        if (!doesFileExists(filePath)) {
            System.err.println("Die Datei \"" + filePath + "\" existiert nicht!");
            return false;
        }

        try {
            Desktop.getDesktop().open(new java.io.File(filePath));
        } catch (IOException e) {
            return false;
        }

        return true;
    }

}
