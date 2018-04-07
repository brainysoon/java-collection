package com.thoughtworks.collection;

import com.thoughtworks.collection.util.BorderUtils;
import com.thoughtworks.collection.util.BorderUtils.Border;
import com.thoughtworks.collection.util.NumberUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Border border = BorderUtils.valueOf(leftBorder, rightBorder);

        return IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .filter(NumberUtils::isEvenNumber)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Border border = BorderUtils.valueOf(leftBorder, rightBorder);

        return IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .filter(NumberUtils::isOddNumber)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(value -> value * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(value -> NumberUtils.isOddNumber(value) ? value * 3 + 2 : value)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(NumberUtils::isOddNumber)
                .mapToInt(value -> value * 3 + 5)
                .sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> sortedEvenList = arrayList.stream()
                .filter(value -> value % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        int length = sortedEvenList.size();
        if (NumberUtils.isEvenNumber(length)) {
            int middleIndex = length / 2;
            return (sortedEvenList.get(middleIndex - 1) + sortedEvenList.get(middleIndex)) / 2;
        } else {
            return sortedEvenList.get((length) / 2);
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        OptionalDouble averageOptional = arrayList.stream()
                .filter(NumberUtils::isEvenNumber)
                .mapToInt(value -> value)
                .average();
        return averageOptional.isPresent() ? averageOptional.getAsDouble() : 0;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(NumberUtils::isEvenNumber)
                .anyMatch(specialElment::equals);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(NumberUtils::isEvenNumber)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return arrayList.stream()
                .sorted((v1, v2) -> {
                    if (NumberUtils.isEvenNumber(v1) && NumberUtils.isEvenNumber(v2)) {
                        return v1 - v2;
                    } else if (NumberUtils.isOddNumber(v1) && NumberUtils.isOddNumber(v2)) {
                        return v2 - v1;
                    } else {
                        return NumberUtils.isEvenNumber(v1) ? -1 : 1;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> timesArray = new ArrayList<>();

        for (int i = 1; i < arrayList.size(); i++) {
            timesArray.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }
        return timesArray;
    }
}
