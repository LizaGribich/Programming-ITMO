package org.lab7.server.commands;

import org.lab7.server.arguments.ExtraModel;
import org.lab7.server.models.FuelType;
import org.lab7.server.models.VehicleType;
import org.lab7.server.*;
import org.lab7.server.models.Vehicle;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Insert implements Comandable, ExtraModel {
    static String name = "insert";
    private MapWrapper<Integer, Vehicle> hashMap;
    public Insert (MapWrapper<Integer, Vehicle> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public CommandResult execute(Object... o) throws Exception {

        String inputString = Arrays.toString(o);
        String[] inputValues = inputString.substring(1, inputString.length() - 1).split(" ");
        String name = inputValues[0];
        Double x = Double.parseDouble(inputValues[1]);
        float y = Float.parseFloat(inputValues[2]);
        Double enginePower = Double.parseDouble(inputValues[3]);
        float capacity = Float.parseFloat(inputValues[4]);
        String type = inputValues[5];
        String fuelType = inputValues[6].substring(0, inputValues[6].length() - 1);
        String userName = inputValues[7];
        System.out.println(fuelType);
        System.out.println(FuelType.valueOf(fuelType));


        Date creationDate = new Date(ThreadLocalRandom.current().nextInt() * 1000L);

        Database.insertBase(name, creationDate, enginePower, capacity,
                VehicleType.valueOf(type), FuelType.valueOf(fuelType), userName);
        MapWrapper<Integer, Vehicle> newHashmap = Database.readBase();

        HashMap<Integer, Boolean> keys = new HashMap<>();
        for (Map.Entry<Integer, Vehicle> newMap : newHashmap.entrySet()) {
            Integer key = newMap.getKey();
            boolean flag = false;
            for (Map.Entry<Integer, Vehicle> oldMap : hashMap.entrySet()) {
                if (key.equals(oldMap.getKey())) {
                    flag = true;
                }
            }
            keys.put(key, flag);
        }
        int id = 0;
        for (Map.Entry<Integer, Boolean> booleanKeys : keys.entrySet()) {
            if (booleanKeys.getValue().equals(false)) {
                hashMap.put(booleanKeys.getKey(), newHashmap.get(booleanKeys.getKey()));
                id = booleanKeys.getKey();
            }
        }


        return new CommandResult("Модель с id = " + id + " успешно добавлена!", true);
    }



    @Override
    public String getDescr() {
        return "Добавить новый элемент с автоматически сгенерированным ключом.\n" +
                "Синтаксис: insert";
    }

    public static String getName() {
        return name;
    }
}