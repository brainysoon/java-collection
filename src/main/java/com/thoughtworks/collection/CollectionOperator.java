package com.thoughtworks.collection;

import com.thoughtworks.collection.util.BorderUtils;
import com.thoughtworks.collection.util.BorderUtils.Border;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        Border border = BorderUtils.valueOf(left, right);

        List<Integer> ascendingOrderList = IntStream.rangeClosed(border.getStartValue(), border.getEndValue())
                .collect(ArrayList::new, List::add, List::addAll);
        if (left > right) {
            return ascendingOrderList.stream()
                    .sorted(Comparator.comparing(Integer::intValue).reversed())
                    .collect(Collectors.toList());
        }
        return ascendingOrderList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        throw new NotImplementedException();
    }

    public List<Integer> popEvenElments(int[] array) {
        throw new NotImplementedException();
    }

    public int popLastElment(int[] array) {
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
