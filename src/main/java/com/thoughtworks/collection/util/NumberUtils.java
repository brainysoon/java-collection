package com.thoughtworks.collection.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtils {

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public static boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    public static List<Integer> inverseNumberArray(List<Integer> numberArray) {
        return numberArray.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
    }

    public static boolean isThreeTimesOf(int number) {
        return number % 3 == 0;
    }
}
