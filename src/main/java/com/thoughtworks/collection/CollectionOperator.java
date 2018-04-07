package com.thoughtworks.collection;

import com.thoughtworks.collection.util.BorderUtils;
import com.thoughtworks.collection.util.BorderUtils.Border;
import com.thoughtworks.collection.util.NumberUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        Border border = BorderUtils.valueOf(left, right);

        List<Integer> ascendingOrderList = IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .collect(ArrayList::new, List::add, List::addAll);
        return left > right ? NumberUtils.inverseNumberArray(ascendingOrderList) : ascendingOrderList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        Border border = BorderUtils.valueOf(left, right);

        List<Integer> ascendingOrderList = IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .filter(NumberUtils::isEvenNumber)
                .collect(ArrayList::new, List::add, List::addAll);
        return left > right ? NumberUtils.inverseNumberArray(ascendingOrderList) : ascendingOrderList;
    }

    public List<Integer> popEvenElments(int[] array) {

        return IntStream.of(array)
                .filter(NumberUtils::isEvenNumber)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        Set<Integer> secondArraySet = Arrays.stream(secondArray)
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        return Arrays.stream(firstArray)
                .filter(secondArraySet::contains)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> resultList = Arrays.stream(firstArray)
                .collect(Collectors.toList());

        Arrays.stream(secondArray)
                .forEach(value -> {
                    if (!resultList.contains(value)) resultList.add(value);
                });
        return resultList;
    }
}
