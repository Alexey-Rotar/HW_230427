package org.example.hw230427.Task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String someStr = sc.nextLine();
        System.out.println("Введите искомое слово:");
        String someWord = sc.nextLine();
        System.out.println("Найдено слов: " + wordSearch(someStr, someWord));
    }

    public static int wordSearch(String str, String word) {
        boolean flag = false;
        Map<String, Integer> searchMap = new HashMap<>();
        String[] checkArray = str.split("");
        for (int i = 0; i < checkArray.length; i++) {
            if (checkArray[i].equals(".") || checkArray[i].equals(",")
                    || checkArray[i].equals("-") || checkArray[i].equals(":") || checkArray[i].equals(";")
                    || checkArray[i].equals("!") || checkArray[i].equals("?")) {
                checkArray[i] = " ";
            }
        }
        str = String.join("", checkArray);
        checkArray = str.toLowerCase().split(" ");
        if (!word.equals("")) {
            word = word.toLowerCase();
            for (int i = 0; i < checkArray.length; i++) {
                if (checkArray[i].equals(word)) {
                    flag = true;
                    searchMap.putIfAbsent(checkArray[i], 0);
                    searchMap.put(checkArray[i], searchMap.get(checkArray[i]) + 1);
                }
            }
        }

        if (flag)
            return searchMap.get(word);
        else
            return 0;
    }
}
