package com.DimitriVranken.DatAdventure;

import com.DimitriVranken.DatAdventure.DataAccess.DataFile;
import com.DimitriVranken.DatAdventure.DataAccess.ManagedProperties;

public class Player {

	// Private Variables
	ManagedProperties playerProperties = new ManagedProperties(DataFile.Player);

	private String name, task;
	private int progress, location;

	// Getters
	public String getName() {
		return name;
	}

	public String getTask() {
		return task;
	}

	public int getProgress() {
		return progress;
	}

	public int getLocation() {
		return location;
	}

	// Setters
	public void setName(String name) {
		this.name = name; // Update local variable
		ManagedProperties.setProperty("name", this.name);
		ManagedProperties.store(playerProperties.getProperties(), DataFile.Player); // Save changes in .properties file
	}

	public void setTask(String task) {
		this.task = task; // Update local variable
		ManagedProperties.setProperty("task", this.task);
		ManagedProperties.store(playerProperties.getProperties(), DataFile.Player); // Save changes in .properties file

		DatAdventure.talkLine("Neue Aufgabe: " + task); // Output new task
	}

	public void setProgress(int progress) {
		this.progress = progress; // Update local variable
		ManagedProperties.setProperty("progress", this.progress);
		ManagedProperties.store(playerProperties.getProperties(), DataFile.Player); // Save changes in .properties file
	}

	public void setLocation(int location) {
		this.location = location; // Update local variable
		ManagedProperties.setProperty("location", this.location);
		ManagedProperties.store(playerProperties.getProperties(), DataFile.Player); // Save changes in .properties file
	}

	// Constructors
	public Player() {
		name =  playerProperties.getString("name");
		task =  playerProperties.getString("task");
		progress = playerProperties.getInteger("progress", -1);
		location =  playerProperties.getInteger("location", 11);
	}

	// Public Methods
	public void outputInformation() {
		com.DimitriVranken.DatAdventure.DatAdventure.talkLine("Spieler: " + name);
		com.DimitriVranken.DatAdventure.DatAdventure.talkLine("Ort: " + DatAdventure.convertLocationToString(location));
		com.DimitriVranken.DatAdventure.DatAdventure.talkLine("Aufgabe: " + task);
	}

}
