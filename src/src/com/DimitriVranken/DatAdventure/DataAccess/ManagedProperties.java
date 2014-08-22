package com.DimitriVranken.DatAdventure.DataAccess;

import com.DimitriVranken.DatAdventure.DatAdventure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ManagedProperties {

	// Variables and getters
	private Properties properties = new Properties();

	public Properties getProperties() {
		return properties;
	}

	// Constructors
	public ManagedProperties(DataFile dataFile) {
        String dataFileName = getDataFileName(dataFile);
        if (dataFileName == null) {
            DatAdventure.outputError("Unbekannte Konfigurations-Datei!"); // Unknown data file
        }

        try {
            properties.load(new FileInputStream(dataFileName)); // Load data file
        }
        catch (Exception ex) {
            DatAdventure.outputError("\"" + dataFileName +"\" kann nicht gelesen werden!");
        }
	}

	// Getting values
	public String getString(String key) {
		return getString(key, "");
	}

	public String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}


	public Integer getInteger(String key, Integer defaultValue) {
		return Integer.parseInt(getString(key, defaultValue.toString()));
	}


    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String propertyString = getString(key, "");

        if (propertyString == "") {
            return defaultValue;
        }
        else {
            return Boolean.parseBoolean(propertyString);
        }
    }

	// Setting values
	public void setProperty(String key, int value) {
		setProperty(key, String.valueOf(value));
	}

	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}


	public static void store(Properties properties, DataFile dataFile) {
        String dataFileName = getDataFileName(dataFile);
        if (dataFileName == null) {
            DatAdventure.outputError("Unbekannte Konfigurations-Datei!"); // Unknown data file
        }

        try {
            properties.store(new FileOutputStream(dataFileName), null); // Set properties
        }
        catch (Exception ex) {
            DatAdventure.outputError("\"" + dataFileName +"\" kann nicht geschrieben werden!");
        }
	}

    // Helpers
    private static String getDataFileName(DataFile dataFile) {
        switch (dataFile) {
            case Application:
                return "configuration/Application.properties";
            case Player:
                return "configuration/Player.properties";
            case NPCs:
                return "resources/NPCs.properties";
            default:
                return null;
        }
    }

}
