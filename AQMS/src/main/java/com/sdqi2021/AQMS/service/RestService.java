package com.sdqi2021.AQMS.service;

import net.minidev.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class RestService {

    RestTemplate restTemplate = new RestTemplate();

    public List<List<String>> sendQueryAllRequest() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("ADMIN", "KYLIN");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create Body
        JSONObject body = new JSONObject();
        body.put("sql", "select * from aqdb.aq order by date_time desc");
        body.put("project", "AQMS");

        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange("http://172.17.0.1:7070/kylin/api/query", HttpMethod.POST, request, Map.class);
        Map data = response.getBody();

        if (data != null) {
            System.out.println("Results Array: " + data.get("results"));
        }
        List<List<String>> lstlststr = (List<List<String>>) data.get("results");
        return lstlststr;
    }

    public List<List<String>> getTotalSensorTypes() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("ADMIN", "KYLIN");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create Body
        JSONObject body = new JSONObject();
        body.put("sql", "SELECT COUNT(DISTINCT STATION_TYPE) FROM AQDB.AQ");
        body.put("project", "AQMS");

        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange("http://172.17.0.1:7070/kylin/api/query", HttpMethod.POST, request, Map.class);
        Map data = response.getBody();

        if (data != null) {
            System.out.println("Results Array: " + data.get("results"));
        }
        List<List<String>> lstlststr = (List<List<String>>) data.get("results");
        return lstlststr;
    }

    public List<List<String>> getTotalStationTypes() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("ADMIN", "KYLIN");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create Body
        JSONObject body = new JSONObject();
        body.put("sql", "SELECT COUNT(DISTINCT STATION_ID) FROM AQDB.AQ;");
        body.put("project", "AQMS");

        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange("http://172.17.0.1:7070/kylin/api/query", HttpMethod.POST, request, Map.class);
        Map data = response.getBody();

        if (data != null) {
            System.out.println("Results Array: " + data.get("results"));
        }
        List<List<String>> lstlststr = (List<List<String>>) data.get("results");
        return lstlststr;
    }

    public List<List<String>> getTotalRowsOfData() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("ADMIN", "KYLIN");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create Body
        JSONObject body = new JSONObject();
        body.put("sql", "SELECT COUNT(*) FROM AQDB.AQ");
        body.put("project", "AQMS");

        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange("http://172.17.0.1:7070/kylin/api/query", HttpMethod.POST, request, Map.class);
        Map data = response.getBody();

        if (data != null) {
            System.out.println("Results Array: " + data.get("results"));
        }
        List<List<String>> lstlststr = (List<List<String>>) data.get("results");
        return lstlststr;
    }

    public void sendCubeRefreshBuildRequest(Long startTimestamp, Long endTimestamp) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("ADMIN", "KYLIN");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create Body
        JSONObject body = new JSONObject();
//        body.put("startTime", startTimestamp);
//        body.put("endTime", endTimestamp);
        //20210501000000_20210502021000
        body.put("startTime", 20210501000000L);
        body.put("endTime", 20210502021000L);
        body.put("buildType", "REFRESH");

        HttpEntity<String> request = new HttpEntity<String>(body.toString(), headers);
        ResponseEntity<Map>  response = restTemplate.exchange("http://172.17.0.1:7070/kylin/api/cubes/AQ_CUBE_0145/build", HttpMethod.PUT, request, Map.class);
        Map data = response.getBody();

        if (data != null) {
            System.out.println("Refresh Build Progress: " + data.get("progress"));
        }
    }

}
