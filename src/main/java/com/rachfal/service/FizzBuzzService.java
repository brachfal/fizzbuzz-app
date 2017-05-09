package com.rachfal.service;

import com.rachfal.model.FizzBuzz;

import java.util.Collection;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */
public interface FizzBuzzService {

    String doFizzBuzz(FizzBuzz data);

    List<String> doFizzBuzz(Collection<FizzBuzz> data);
}
