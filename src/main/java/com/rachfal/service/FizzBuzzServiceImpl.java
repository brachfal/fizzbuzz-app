package com.rachfal.service;

import com.rachfal.model.FizzBuzz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private List<Processor> processors;

    public FizzBuzzServiceImpl() {
    }

    public FizzBuzzServiceImpl(final List<Processor> processors) {
        this.processors = processors;
    }

    @Override
    public String doFizzBuzz(final FizzBuzz data) {
        initProcessors(data);
        final StringBuilder result = new StringBuilder();
        for (int i = 1; i <= data.getCounter(); i++) {
            result.append(createResultToken(i));
            result.append(" ");
        }

        return result.toString().trim();
    }

    @Override
    public List<String> doFizzBuzz(final Collection<FizzBuzz> data) {
        final List<String> result = new ArrayList<>();
        for (final FizzBuzz fizzBuzz : data) {
            result.add(doFizzBuzz(fizzBuzz));
        }
        return result;
    }

    private void initProcessors(final FizzBuzz data) {
        for (int i = 0; i < processors.size(); i++) {
            processors.get(i).setDivider(data.getDividers().get(i));
        }
    }

    private String createResultToken(final int number) {
        final StringBuilder resultToken = new StringBuilder();
        for (final Processor processor : getProcessorsToFireFor(number)) {
            resultToken.append(processor.process(number));
        }
        if (resultToken.length() == 0) {
            resultToken.append(String.valueOf(number));
        }
        return resultToken.toString();
    }

    private Collection<Processor> getProcessorsToFireFor(final int number) {
        final List<Processor> processorsToFire = new ArrayList<Processor>();
        for (final Processor processor : processors) {
            if (processor.shouldFire(number)) {
                processorsToFire.add(processor);
            }
        }
        return processorsToFire;
    }

}
