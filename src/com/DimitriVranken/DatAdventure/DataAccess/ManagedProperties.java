package com.DatAdventure.DataAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.DatAdventure.DatAdventure;

public class ManagedProperties {

	// Private Static Variables
	private static Properties properties = new Properties();

	// Getters
	public Properties getProperties() {
		return properties;
	}

	// Constructors
	public ManagedProperties(DataFile dataFile) {
		switch (dataFile) {
		case Player:
			try {
				properties.load(new FileInputStream("Spieler.properties")); // Load "spieler.properties"
			}
			catch (Exception ex) {
				DatAdventure.outputError("\"Spieler.properties\" kann nicht gelesen werden!!");
			}
			break;
		case NPCs:
			try {
				properties.load(new FileInputStream("NPCs.properties")); // Load "NPCs.properties"
			}
			catch (Exception ex) {
				ex.printStackTrace();
				DatAdventure.outputError("\"NPCs.properties\" kann nicht gelesen werden!");
			}
			break;
		default:
			DatAdventure.outputError("Unbekannte Datei kann nicht gelesen werden"); // Unknown enumerator value
		}
	}

	// Public Methods
	public String getString(String key) {
		return getString(key, "");
	}

	public String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public Integer getInteger(String key, Integer defaultValue) {
		return Integer.parseInt(getString(key, defaultValue.toString()));
	}

	// Public Static Methods
	public static void setProperty(String key, int value) {
		setProperty(key, String.valueOf(value));
	}

	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	public static void store(Properties properties, DataFile dataFile) {
		switch (dataFile) {
		case Player:
			try {
				properties.store(new FileOutputStream("Spieler.properties"), null); // Set "Spieler.properties"
			}
			catch (Exception ex) {
				DatAdventure.outputError("\"Spieler.properties\" kann nicht geschrieben werden!!");
			}
			break;
		default:
			DatAdventure.outputError("Unbekannte Datei kann nicht geschrieben werden"); // Unknown enumerator value
		}
	}

}
