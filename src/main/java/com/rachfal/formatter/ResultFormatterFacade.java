package com.rachfal.formatter;

import com.rachfal.model.FizzBuzz;
import com.rachfal.service.FizzBuzzService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */
@Service
public class ResultFormatterFacade {

    private FizzBuzzService fizzBuzzService;
    private Formatter formatter;

    public ResultFormatterFacade(FizzBuzzService fizzBuzzService, Formatter formatter) {
        this.fizzBuzzService = fizzBuzzService;
        this.formatter = formatter;
    }

    public List<String> listFormat(final Collection<FizzBuzz> data) {
        return formatter.format(getResult(data));
    }

    private List<String> getResult(final Collection<FizzBuzz> data) {
        return fizzBuzzService.doFizzBuzz(data);
    }

}
