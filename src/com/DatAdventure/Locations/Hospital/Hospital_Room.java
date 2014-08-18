package com.DatAdventure.Locations.Hospital;

import static com.DatAdventure.DatAdventure.getMenuItemChoice;
import static com.DatAdventure.DatAdventure.outputNextDay;
import static com.DatAdventure.DatAdventure.player;
import static com.DatAdventure.DatAdventure.talkLine;

import com.DatAdventure.DatAdventure;
import com.DatAdventure.NPC;

public class Hospital_Room {

	// Private Static Variables
	private static NPC father = new NPC("hospital_room_father");
	private static NPC nurse = new NPC("hospital_room_nurse");
	private static NPC doctor = new NPC("hospital_room_doctor");

	private static int playerStayedDaysToRecover = 0;

	// Public Static Methods
	public static void enter() {
		if (player.getProgress() < 1) { // Do an introduction
			if (player.getProgress() == -1) { // Start the adventure
				startAdventure();
			}
			doIntroduction();
		}
		else { //Enter the location
			talkLine("\nDu betrittst das Krankenhauszimmer.");
		}

		//Run location-loop
		do  {
			outputMenu();
		} while (player.getLocation() == 11); // If the player hasn't changed location, ask him what to do (again)
	}

	// Private Static Output Methods
	private static void outputMenu() {
		switch (getMenuItemChoice("Was möchtest du tun?", new String[] {"Mit Person sprechen",
				"Ort wechseln (" + DatAdventure.convertLocationToString(player.getLocation()) + ")"})) { // Ask the player what to do
				case 1:
					outputTalkToPerson(); // List the persons in this location
					break;
				case 2:
					outputChangeLocation(); // List the reachable locations from here
		}
	}

	private static void outputTalkToPerson() {
		switch (getMenuItemChoice("Mit wem möchtest du sprechen?",new String[] {"Zurück zum Menu",
				"Krankenschwester",
		"Arzt"})) { // Ask the player who to talk to
		case 1:
			return;
		case 2:
			nurse.talkTo(); // Talk to the nurse
			break;
		case 3:
			doctor.talkTo(); // Talk to the doctor
		}
		outputTalkToPerson();
	}

	private static void outputChangeLocation() {
		switch (getMenuItemChoice("Wohin möchtest du gehen?", new String[] {"Zurück zum Menü",
				"Krankenhaus verlassen",
				"Abgabe",
		"Büro des Chefarztes"})) { // Ask the player where to go
		case 2:
			com.DatAdventure.Locations.Hospital.Hospital.outputLocationsToGo(); // 
			break;
		case 3:
			player.setLocation(12); // Set the player to the discharge station
			break;
		case 4:
			player.setLocation(13); // Set the player to the office of the head physician
		}
	}

	// Private Static Introduction Methods
	private static void startAdventure() {
		talkLine("Willkommen bei \"Dat Adventure\"");
		player.setName(DatAdventure.getStringInput(null, "Wie möchtest du heissen?", "Name", 3, 12)); // Ask the player for his name
		talkLine("Das ist ein schöner Name.");
		talkLine("Viel Spass bei deinem Abenteuer!\n\n", 500);
		player.setProgress(0); // Set the progress of the player to "adventure started"
	}

	private static void doIntroduction() {
		father.talkLine("Hallo " + player.getName() + "!");

		Boolean playerCanRememberAccident = father.ask("Kannst du dich an irgendetwas erinnern"); // Ask the player if he can remember the accident
		if (playerCanRememberAccident) {
			father.talkLine("Gut, aber ich werde dir zur Sicherheit alles nochmals in Ruhe erklären.");
		}
		else {
			father.talkLine("Das ist überhaupt kein Problem, ich werde dir erzählen was geschehen ist.");
		}
		father.talkLine("Du hattest einen Unfall und bist nun im Krankenhaus.");
		father.talkLine("Du warst in der Arena in Metapolcity, als du von einem der kämpfenden Roboter erwischt wurdest.");
		father.talkLine("Eine Frau hat mir erzählt das du zurückgeschleudert wurdest und auf dem Kopf gelandet bist.");
		if (playerCanRememberAccident == false) {
			father.talkLine("Aber an die letzten Momente vor dem Unfall wirst du dich wohl nie mehr erinnern können.");
		}
		father.talkLine("Die Ärzte sagen das Sie dich noch eine Nacht hier behalten wollen, morgen darfst du aber schon nach Hause kommen.");
		father.talkLine("Mam und deine Schwester konnten leider nicht herkommen, aber ich bin mir sicher dass sie sich freuen werden dich zu sehen.");
		father.talkLine("Ruh dich jetz noch ein wenig aus, morgen komme ich dich abholen.");


		waitForPlayerToWantToGoHome();  // Wait for the player to go home
		nurse.talkLine("Dein Vater wartet unten schon auf dich.");
		nurse.talkLine("Du kannst dir noch deine Sachen bei der Abgabe holen.");
		nurse.talkLine("Tschüüss, besuch uns nicht bald wieder.\n");

		// Set the progress of the player to "introduction completed"
		player.setProgress(1);
		player.setTask("Hole deine Sachen von der Abgabe und gehe dann zu deinem Vater");
	}

	private static void waitForPlayerToWantToGoHome() {
		outputNextDay();
		playerStayedDaysToRecover ++; // Increase days that player stayed to recover

		nurse.talkLine("Guten Morgen.");
		if (playerStayedDaysToRecover < 4) {
			askPlayerIfHeWantsToGoHome(); // Ask the player if he wants to stay to recover one more day (again)
		}
		else {
			nurse.talkLine("Du hast dich nun lange genug ausgeruht."); // The player can't stay anymore
		}
	}

	private static void askPlayerIfHeWantsToGoHome() {
		if (nurse.ask("Fühlst du dich gut genug um nach Hause zu gehen") == false) {
			if (nurse.ask("Möchtest du noch einen Tag hier bleiben und dich erholen")) {
				waitForPlayerToWantToGoHome(); // Stay another day
			}
			else {
				askPlayerIfHeWantsToGoHome();
			}
		}
	}

}
