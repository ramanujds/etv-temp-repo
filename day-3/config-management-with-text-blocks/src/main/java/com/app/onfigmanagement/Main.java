package com.app.onfigmanagement;

import com.app.onfigmanagement.configuration.ConfigurationManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Path configFilePath = Paths.get("config.properties");
        ConfigurationManager configManager = new ConfigurationManager(configFilePath);

        try {
            // TODO: Test reading the configuration
            String currentConfig = configManager.readConfiguration();
            System.out.println("Current Configuration:\n" + currentConfig);

            // TODO: Test updating the configuration
            String updatedConfig = currentConfig + "\nnew_property=value";
            configManager.updateConfiguration(updatedConfig);
            System.out.println("Configuration Updated.");

            // TODO: Test generating a sample configuration with embedded logic
            String sampleConfig = configManager.generateSampleConfiguration();
            System.out.println("Sample Configuration:\n" + sampleConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
