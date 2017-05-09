package com.rachfal.model;

import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-22.
 */
public class FizzBuzz {

    private List<Integer> dividers;
    private int counter;

    public FizzBuzz() {
    }

    public List<Integer> getDividers() {
        return dividers;
    }

    public void setDividers(List<Integer> dividers) {
        this.dividers = dividers;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(final int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "FizzBuzz{" +
                "counter=" + counter +
                ", dividers=" + dividers +
                '}';
    }
}
