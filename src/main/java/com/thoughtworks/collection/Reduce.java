package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

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
        throw new NotImplementedException();
    }

    public int getFirstEven() {
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
