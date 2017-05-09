package com.rachfal.service;

/**
 * Created by Bartlomiej Rachfal on 2016-05-22.
 */
public class Processor {

    private int divider;
    private final String letter;

    public Processor(final String letter) {
        this.letter = letter;
    }

    public String process(final int number) {
        return (number % divider == 0) ? letter : "";
    }

    public boolean shouldFire(final int number) {
        return number % divider == 0;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }
}
