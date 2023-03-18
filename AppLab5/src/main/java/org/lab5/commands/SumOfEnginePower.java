package org.lab5.commands;

import org.lab5.Comandable;
import org.lab5.models.Vehicle;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class SumOfEnginePower implements Comandable {
    static String name = "sum_of_engine_power";

    public static String getName() {
        return name;
    }

    @Override
    public void execute(HashMap<Integer, Vehicle> hashMap, Object... o) throws ParseException, IOException {
        Double summa = 0.0;
        for (Vehicle value : hashMap.values()) {
            summa += value.getEnginePower();
        }
        System.out.println("Сумма значений поля EnginePower для всех элементов коллеции = " + summa);
    }

    @Override
    public String getDescr() {
        return "Вывести сумму значений поля enginePower для всех элементов коллекции.\n" +
                "Синтаксис: sum_of_engine_power";
    }
}