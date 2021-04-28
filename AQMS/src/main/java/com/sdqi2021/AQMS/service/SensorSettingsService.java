package com.sdqi2021.AQMS.service;

import com.sdqi2021.AQMS.model.SensorSettings;
import com.sdqi2021.AQMS.repo.SensorSettingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Service
public class SensorSettingsService {

    @Autowired
    SensorSettingsRepo sensorSettingsRepo;

    public SensorSettings getSettings() {

        SensorSettings settings = sensorSettingsRepo.findById(1).orElse(initialSettings());
        return settings;
    }

    private SensorSettings initialSettings() {

        SensorSettings settings;

        if (sensorSettingsRepo.findAll().size() == 0) {
            settings = SensorSettings.builder()
                    .settingsId(1)
                    .serverRunning(true)
                    .refreshIntervalSeconds(300)
                    .lastUpdated(Date.valueOf(LocalDate.now()))
                    .build();

            sensorSettingsRepo.save(settings);
        }
        return sensorSettingsRepo.findById(1).orElse(new SensorSettings());
    }

    @Transactional
    public void updateLastUpdateDate() {
        getSettings().setLastUpdated(Date.valueOf(LocalDate.now()));
    }
}
