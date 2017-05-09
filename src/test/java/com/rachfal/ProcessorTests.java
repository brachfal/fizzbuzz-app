package com.rachfal;

import com.rachfal.service.Processor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bartek on 2016-05-30.
 */
public class ProcessorTests {

    @Test
    public void shouldProcess() {
        final Processor processor = new Processor("F");
        processor.setDivider(2);
        Assert.assertEquals("F", processor.process(2));
    }

    @Test
    public void shouldNotProcess() {
        final Processor processor = new Processor("F");
        processor.setDivider(2);
        Assert.assertEquals("", processor.process(3));
    }


    @Test
    public void shouldFire() {
        final Processor processor = new Processor("F");
        processor.setDivider(2);
        Assert.assertEquals(true, processor.shouldFire(2));
    }

    @Test
    public void shouldReturnFBForTwoProcessors() {
        final int firstDivider = 2;
        final int secondDivider = 5;
        final int number = 10;
        final Processor fizz = new Processor("F");
        final Processor buzz = new Processor("B");
        fizz.setDivider(firstDivider);
        buzz.setDivider(secondDivider);
        StringBuilder result = new StringBuilder(2);
        result.append(fizz.process(number))
                .append(buzz.process(number));
        Assert.assertEquals("FB", result.toString());

    }
}
