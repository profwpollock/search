package com.wpollock.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Here we put code to run after Spring framework initializes, but before the
 * application starts. In this case, we need to load in the JSON data (if any)
 * and initialize the two data structures, the list of files indexed and the
 * index data (a Map).
 *
 * @author Wayne Pollock
 */
@Component
public class AppInit implements ApplicationRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Loading data");
        // Attempt to open saved JSON data file
        // if works, initialize the Map and List from that data,
        // else create empty Map and List.
    }
}
