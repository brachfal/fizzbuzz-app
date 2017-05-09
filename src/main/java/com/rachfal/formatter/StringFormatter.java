package com.rachfal.formatter;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */

@Component
public class StringFormatter implements Formatter {

    public List<String> format(final Collection<String> data) {
        return (List<String>) data;
    }

    public String format(final String data) {
        return data;
    }
}
