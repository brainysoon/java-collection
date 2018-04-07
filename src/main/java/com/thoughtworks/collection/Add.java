package com.thoughtworks.collection;

import com.thoughtworks.collection.util.BorderUtils;
import com.thoughtworks.collection.util.BorderUtils.Border;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Border border = BorderUtils.valueOf(leftBorder, rightBorder);

        return IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .filter(value -> value % 2 == 0)
                .sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        Border border = BorderUtils.valueOf(leftBorder, rightBorder);

        return IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .filter(value -> value % 2 != 0)
                .sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(value -> value * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(value -> value % 2 != 0 ? value * 3 + 2 : value)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(value -> value % 2 != 0)
                .mapToInt(value -> value * 3 + 5)
                .sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> sortedEvenList = arrayList.stream()
                .filter(value -> value % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        int length = sortedEvenList.size();
        if (length % 2 == 0) {
            int middleIndex = length / 2;
            return (sortedEvenList.get(middleIndex - 1) + sortedEvenList.get(middleIndex)) / 2;
        } else {
            return sortedEvenList.get((length) / 2);
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        OptionalDouble averageOptional = arrayList.stream()
                .filter(value -> value % 2 == 0)
                .mapToInt(value -> value)
                .average();
        return averageOptional.isPresent() ? averageOptional.getAsDouble() : 0;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(value -> value % 2 == 0)
                .anyMatch(specialElment::equals);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(value -> value % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        return arrayList.stream()
                .sorted((v1, v2) -> {
                    if (v1 % 2 == 0 && v2 % 2 == 0) {
                        return v1 - v2;
                    } else if (v1 % 2 != 0 && v2 % 2 != 0) {
                        return v2 - v1;
                    } else {
                        return v1 % 2 == 0 ? -1 : 1;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
