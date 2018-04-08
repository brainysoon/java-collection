package com.thoughtworks.collection;

import com.thoughtworks.collection.util.NumberUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream()
                .reduce(Integer.MIN_VALUE, (max, value) -> max < value ? value : max);
    }

    public double getMinimum() {
        return this.arrayList.stream()
                .reduce(Integer.MAX_VALUE, (min, value) -> min > value ? value : min);
    }

    public double getAverage() {
        if (arrayList.isEmpty()) throw new RuntimeException("Must contain element");

        return this.arrayList.stream()
                .reduce(0, (sum, value) -> sum + value) / (double) arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> sortedEvenList = this.arrayList.stream()
                .sorted()
                .collect(Collectors.toList());
        int length = sortedEvenList.size();
        if (NumberUtils.isEvenNumber(length)) {
            int middleIndex = length / 2;
            return (sortedEvenList.get(middleIndex - 1) + sortedEvenList.get(middleIndex)) / 2.0;
        } else {
            return sortedEvenList.get((length) / 2);
        }
    }

    public int getFirstEven() {
        return this.arrayList.stream()
                .filter(NumberUtils::isEvenNumber)
                .findFirst()
                .get();
    }

    public int getIndexOfFirstEven() {
        return this.arrayList.stream()
                .reduce(0, (index, value) -> {
                    if (index > 0) return index;
                    else {
                        if (NumberUtils.isOddNumber(value)) {
                            return index - 1;
                        } else {
                            return -index;
                        }
                    }
                });
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        return this.arrayList.stream()
                .reduce(0, (odd, value) -> {
                    if (NumberUtils.isOddNumber(value)) return value;
                    return odd;
                });
    }

    public int getIndexOfLastOdd() {
        return this.arrayList.lastIndexOf(this.arrayList.stream()
                .reduce(0, (odd, value) -> {
                    if (NumberUtils.isOddNumber(value)) return value;
                    return odd;
                }));
    }
}
