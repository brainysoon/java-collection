package com.thoughtworks.collection;

import com.thoughtworks.collection.util.BorderUtils;
import com.thoughtworks.collection.util.BorderUtils.Border;
import com.thoughtworks.collection.util.NumberUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
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
        throw new NotImplementedException();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
