package com.sdqi2021.AQMS.service;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class JobSchedulerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobSchedulerService.class);

    @Autowired
    StationService stationService;

    Timer timer;

    private int runCount = 0;

    public void startRetrievingStations() {

        // Create Timer Task
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                if (runCount >= 3) {
                    stopRetrievingStations();
                    return;
                }
                try {
                    stationService.retrieveAndSaveAllStations();
                    runCount = runCount + 1;
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                    LOGGER.error("Localized Error: " + e.getLocalizedMessage());
                }
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0L, 10000L);

        LOGGER.info("--- 10s Timer started with fixed rate scheduling... ---");
        LOGGER.info("Run Count: {}", runCount);
    }

    public void stopRetrievingStations() {
        timer.cancel();
        timer = null;
        runCount = 0;
        LOGGER.info("--- Timer cancelled ! ---");
        LOGGER.info("Run Count: {}", runCount);
    }

    public int getRunCount() {
        return runCount;
    }
}
