package org.lab7.client.arguments;

import org.lab7.client.ConsolePrinter;
import org.lab7.client.commands.EnterField;
import org.lab7.client.models.FuelType;
import org.lab7.client.models.VehicleType;


public class ExtraModel {
    private String name;
    private Double x;
    private float y;
    private Double enginePower;
    private float capacity;
    private String type;
    private String fuelType;

    public void putData(Object... o) {

        ConsolePrinter consolePrinter = new ConsolePrinter();

        EnterField enterField = new EnterField();
        String name = enterField.enterString("name");
        Double x = enterField.enterDouble("coordinates x");
        float y = enterField.enterFloat("coordinates y");

        Double enginePower = enterField.enterDouble("enginePower");
        float capacity = enterField.enterFloat("capacity");

        String type = enterField.enterString("type (CAR, DRONE, CHOPPER, HOVERBOARD, SPACESHIP)");

        while (true) {
            try {
                VehicleType.valueOf(type);
                break;
            } catch (IllegalArgumentException e) {
                consolePrinter.printToConsole("Такого значения не существует.");
                type = enterField.enterString("type (CAR, DRONE, CHOPPER, HOVERBOARD, SPACESHIP)");
            }
        }

        String fuelType = enterField.enterString("fuelType (GASOLINE, MANPOWER, PLASMA, ANTIMATTER)");

        while (true) {
            try {
                FuelType.valueOf(fuelType);
                break;
            } catch (IllegalArgumentException e) {
                consolePrinter.printToConsole("Такого значения не существует.");
                fuelType = enterField.enterString("fuelType (GASOLINE, MANPOWER, PLASMA, ANTIMATTER)");
            }
        }



        this.name = name;
        this.x = x;
        this.y = y;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.type = type;
        this.fuelType = fuelType;
    }

    public String getName() {
        return name;
    }
    public Double getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public String getType() {
        return type;
    }
    public String getFuelType() {
        return fuelType;
    }
    public Double getEnginePower() {
        return enginePower;
    }
    public float getCapacity() {
        return capacity;
    }

}