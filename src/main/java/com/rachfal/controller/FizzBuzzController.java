package com.rachfal.controller;

import com.rachfal.formatter.ResultFormatterFacade;
import com.rachfal.model.FizzBuzz;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */
@RestController
public class FizzBuzzController {

    private final FizzBuzzValidator validator;

    private final ResultFormatterFacade resultFormatterFacade;

    public FizzBuzzController(final FizzBuzzValidator validator, final ResultFormatterFacade resultFormatterFacade) {
        this.validator = validator;
        this.resultFormatterFacade = resultFormatterFacade;
    }

    @RequestMapping(value = "/fizzBuzz", method = RequestMethod.POST)
    public
    @ResponseBody
    List<String> doFizzBuzz(@Valid @RequestBody List<FizzBuzz> data, BindingResult result) {
        validator.validate(data, result);
        if (result.hasErrors()) {
            return getErrorsListFrom(result);
        } else {
            return resultFormatterFacade.listFormat(data);
        }
    }

    private List<String> getErrorsListFrom(final BindingResult result) {
        final List<String> errors = new ArrayList<>();
        for (final ObjectError objectError : result.getAllErrors()) {
            errors.add(objectError.getCode());
        }
        return errors;
    }

}
