package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Такой команды нет");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        if (dishType.isEmpty() || dishName.isEmpty()) {
            System.out.println("Некорректный ввод");
            return;
        }
        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.dishTypes.isEmpty()) {
            System.out.println("Вы пока не добавили ни одного блюда.");
            return;
        }

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> listTypes = new ArrayList<>();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (!dc.checkType(nextItem)) {
                System.out.println("Такого типа нет. Введите еще раз");
            } else {
                listTypes.add(nextItem);
            }
            nextItem = scanner.nextLine();
        }
        ArrayList<ArrayList<String>> comboMenu = dc.makeCombo(listTypes, numberOfCombos);
        for (int i = 0; i < comboMenu.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(comboMenu.get(i));
        }
    }
}
