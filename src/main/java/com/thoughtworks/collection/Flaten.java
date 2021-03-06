package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(this.array)
                .flatMap(Arrays::stream)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return Arrays.stream(this.array)
                .flatMap(Arrays::stream)
                .distinct()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
