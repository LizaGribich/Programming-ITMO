package org.lab6.server;

import org.lab6.server.models.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        MapWrapper<Integer, Vehicle> hashMap = new MapWrapper<>(HashMap.class);
        CollectionManager collectionManager = new CollectionManager<>(hashMap);
        try {
            //C:\Users\liza6\IdeaProjects\AppLab5_\src\data.json
            MapWrapper<Integer, Vehicle> vehicleCollection = collectionManager.deserialize(new File("C:\\Users\\liza6\\IdeaProjects\\AppLab5_\\src\\data.json"));
            CommandManager commandManager = new CommandManager(vehicleCollection);
            commandManager.makeCollectionOfCommands();
            InteractiveMode.interactiveModeOn(commandManager.getCommands(), vehicleCollection);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}