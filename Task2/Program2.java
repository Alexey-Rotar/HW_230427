package org.example.hw230427.Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program2 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> searchMap = searchNames("data.txt");
        for (Map.Entry<String, Integer> entry : searchMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static Map<String, Integer> searchNames(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Map<String, Integer> namesMap = new HashMap<>();
        String str;
        String[] tempArray;
        while ((str = br.readLine()) != null) {
            tempArray = str.split(" ");
            namesMap.putIfAbsent(tempArray[0], 0);
            namesMap.put(tempArray[0], namesMap.get(tempArray[0]) + 1);
        }
        br.close();

        Map<String, Integer> sortedNamesMap = namesMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
        return sortedNamesMap;
    }

}
