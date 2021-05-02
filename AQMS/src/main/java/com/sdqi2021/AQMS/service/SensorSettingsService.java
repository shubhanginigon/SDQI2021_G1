package com.sdqi2021.AQMS.service;

import com.sdqi2021.AQMS.model.AQData;
import com.sdqi2021.AQMS.model.SensorSettings;
import com.sdqi2021.AQMS.repo.SensorSettingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensorSettingsService {

    @Autowired
    SensorSettingsRepo sensorSettingsRepo;

    @Autowired
    RestService restService;

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

    // REST API CALLS
    public List<AQData> queryAll() {

        List<List<String>> results = restService.sendQueryAllRequest();

        List<AQData> listAQData = new ArrayList<AQData>();

        for (List<String> result: results) {
            AQData aqData = new AQData();
            aqData.setStation_id(result.get(0));
            aqData.setStation_name(result.get(1));
            aqData.setArea(result.get(2));
            aqData.setStation_type(result.get(3));
            aqData.setLatitude(Double.parseDouble(result.get(4)));
            aqData.setLongitude(Double.parseDouble(result.get(5)));

            int pm_value;
            try {
                pm_value = Integer.parseInt(result.get(6));
            } catch (Exception e) {
                pm_value = 0;
            }
            aqData.setPm_value(pm_value);

            aqData.setProvince(result.get(7));
            aqData.setDate_time(result.get(8));

            listAQData.add(aqData);
        }

        return listAQData;
    }
}
