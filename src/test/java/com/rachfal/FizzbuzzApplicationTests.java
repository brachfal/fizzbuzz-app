package com.rachfal;

import com.rachfal.model.FizzBuzz;
import com.rachfal.service.FizzBuzzService;
import com.rachfal.service.Processor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FizzbuzzApplication.class)
public class FizzbuzzApplicationTests {

    @Autowired
    private ApplicationContext context;

    private FizzBuzzService service;

    @Before
    public void setUp() {
        this.service = (FizzBuzzService) context.getBean("fizzBuzzService");
    }

    @Test
    public void testFizzBuzzService() {
        final FizzBuzz fizzBuzz = new FizzBuzz();
        final List<Integer> dividers = new ArrayList<>(2);
        dividers.add(3);
        dividers.add(5);
        fizzBuzz.setDividers(dividers);
        fizzBuzz.setCounter(10);

        final List<Processor> processors = new ArrayList<>(2);
        processors.add(new Processor("F"));
        processors.add(new Processor("B"));
        final String result = service.doFizzBuzz(fizzBuzz);
        Assert.assertEquals("1 2 F 4 B F 7 8 F B", result);
    }
}
