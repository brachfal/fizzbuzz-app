package com.rachfal.controller;

import com.rachfal.model.FizzBuzz;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by Bartek on 2016-05-30.
 */
@Component
public class FizzBuzzValidator implements Validator {

    private int dividerMin;
    private int dividerMax;
    private int counterMin;
    private int counterMax;

    public FizzBuzzValidator(int dividerMin, int dividerMax, int counterMin, int counterMax) {
        this.dividerMin = dividerMin;
        this.dividerMax = dividerMax;
        this.counterMin = counterMin;
        this.counterMax = counterMax;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FizzBuzz.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        final List<FizzBuzz> data = (List<FizzBuzz>) target;

        for (final FizzBuzz fizzBuzz : data) {

            for (final int divider : fizzBuzz.getDividers()) {
                if (isNotInRange(divider, dividerMin, dividerMax)) {
                    errors.reject("divider: " + divider + " not in range", "not.in.range");
                }
            }

            if (isNotInRange(fizzBuzz.getCounter(), counterMin, counterMax)) {
                errors.reject("counter: " + fizzBuzz.getCounter() + " not in range", "not.in.range");
            }
        }

    }

    private boolean isNotInRange(final int value, final int valueMin, final int valueMax) {
        return !isInRange(value, valueMin, valueMax);
    }

    private boolean isInRange(final int value, final int valueMin, final int valueMax) {
        return value >= valueMin && value <= valueMax;
    }

}
