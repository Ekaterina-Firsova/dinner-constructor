package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes;

    DinnerConstructor() {
        dishTypes = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        if (!checkType(dishType)) {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypes.put(dishType, dishNames);
        } else {
            if (!checkName(dishType, dishName)) {
                ArrayList<String> dishNames = dishTypes.get(dishType);
                dishNames.add(dishName);
            }
        }
    }

    boolean checkType(String type) {
        return dishTypes.containsKey(type);
    }

    boolean checkName(String dishType, String name) {
        ArrayList<String> dishNames = dishTypes.get(dishType);
        return dishNames.contains(name);
    }

    ArrayList<ArrayList<String>> makeCombo(ArrayList<String> listTypes, int numberOfCombos) {
        ArrayList<ArrayList<String>> comboMenu = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishName = new ArrayList<>();
            for (String type : listTypes) {
                ArrayList<String> names = dishTypes.get(type);
                dishName.add(names.get(random.nextInt(names.size())));
            }
            comboMenu.add(dishName);
        }
        return comboMenu;

    }
}
