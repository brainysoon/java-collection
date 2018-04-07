package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        return IntStream.iterate(number - 2, value -> value - 2)
                .limit(number / 2)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
