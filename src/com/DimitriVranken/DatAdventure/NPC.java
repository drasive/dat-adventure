package com.DatAdventure;

import com.DatAdventure.DataAccess.DataFile;
import com.DatAdventure.DataAccess.ManagedProperties;

public class NPC {

	// Protected Variables
	protected String name;
	protected String textOnApproach;

	// Getters
	public String getName() {
		return name;
	}

	public String getTextOnApproach() {
		return textOnApproach;
	}

	// Constructors
	public NPC(String name) {
		ManagedProperties npcProperties = new ManagedProperties(DataFile.NPCs);

		this.name = npcProperties.getString(name + ".name");
		textOnApproach = npcProperties.getString(name + ".textOnApproach").replace("&player.name%", com.DatAdventure.DatAdventure.player.getName()); // Replace placeholders with variables
	}

	// Public Methods
	public boolean ask(String text) {
		return ask(text, '?');
	}

	public boolean ask(String text, char punctuation) {
		DatAdventure.output(name + ": "); // Output name
		DatAdventure.talk(text + " (y/n)" + punctuation + " "); // Output text
		return DatAdventure.getBooleanInput(); // Return answer
	}

	// Public Output Methods
	public void talkTo() {
		talkLine(textOnApproach);
	}

	public void talkLine(String text) {
		talkLine(text, 200);
	}

	public void talkLine(String text, long wait) {
		talk(text + "\n", 200);
	}

	public void talk(String text) {
		talk(text, 200);
	}

	public void talk(String text, long wait) {
		DatAdventure.output(name + ": ");
		DatAdventure.talk(text, wait);
	} 

}
