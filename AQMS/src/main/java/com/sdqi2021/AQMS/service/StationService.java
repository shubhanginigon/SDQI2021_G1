package com.sdqi2021.AQMS.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdqi2021.AQMS.model.dataModel.LastUpdate;
import com.sdqi2021.AQMS.model.dataModel.PM25;
import com.sdqi2021.AQMS.model.dataModel.Station;
import com.sdqi2021.AQMS.repo.StationRepo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

@Service
public class StationService {

    @Autowired
    StationRepo stationRepo;

    Timer timer;

    public void saveAll(List<Station> stations) {
        System.out.println("SAVING " + stations.size() + " stations to database");
        stationRepo.saveAll(stations);
    }

    public void retrieveAndSaveAllStations() throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL("http://www.air4thai.com/services/getNewAQI_JSON.php");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            StringBuilder inline = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            // Write all the JSON data into a string using a scanner
            while(scanner.hasNext()) {
                inline.append(scanner.nextLine());
            }

            // Close the scanner
            scanner.close();

            // Using the JSON simple library parse the string into a json object
            JSONParser parser = new JSONParser();
            JSONObject data_object = (JSONObject) parser.parse(inline.toString());

            // Get the required object from the above created object
            JSONArray stationsArray = (JSONArray) data_object.get("stations");

            List<Station> stations = new ArrayList<>();

            for (Object station: stationsArray) {

                JSONObject stationObject = (JSONObject) station;
                Station st = new Station();
                st.setStationID((String) stationObject.get("stationID"));
                st.setNameTH((String) stationObject.get("nameTH"));
                st.setNameEN((String) stationObject.get("nameEN"));
                st.setAreaTH((String) stationObject.get("areaTH"));
                st.setAreaEN((String) stationObject.get("areaEN"));
                st.setStationType((String) stationObject.get("stationType"));
                st.setLat((String) stationObject.get("lat"));
                st.setLongitude((String) stationObject.get("long"));


                // For StationH end

                JSONObject lastUpdateObject = (JSONObject) stationObject.get("LastUpdate");
                LastUpdate lastUpdate = new LastUpdate();
                lastUpdate.setDate((String) lastUpdateObject.get("date"));
                lastUpdate.setTime((String) lastUpdateObject.get("time"));

                JSONObject pm25Object = (JSONObject) lastUpdateObject.get("PM25");
                PM25 pm25 = new PM25();
                pm25.setValue((String) pm25Object.get("value"));
                pm25.setUnit((String) pm25Object.get("unit"));

                lastUpdate.setPM25(pm25);
                st.setLastUpdate(lastUpdate);

                stations.add(st);
            }

            saveAll(stations);
        }
    }
}