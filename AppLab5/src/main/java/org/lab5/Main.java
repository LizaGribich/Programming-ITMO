package org.lab5;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.lab5.models.Vehicle;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        HashMap<Integer, Vehicle> vehicleCollection = new HashMap<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        Vehicle[] vs = objectMapper.readValue(file, Vehicle[].class);

        for (int i = 0; i < vs.length; i++) {
            vehicleCollection.put(vs[i].getId(), vs[i]);
        }

        CommandManager commandManager = new CommandManager();
        commandManager.makeCollectionOfCommands();

        InteractiveMode.interactiveModeOn(commandManager.getCommands(), vehicleCollection);
    }
}