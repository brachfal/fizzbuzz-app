package com.rachfal.formatter;

import java.util.Collection;
import java.util.List;

/**
 * Created by Bartlomiej Rachfal on 2016-05-20.
 */
public interface Formatter {

    List<String> format(Collection<String> data);

    String format(String data);
}
