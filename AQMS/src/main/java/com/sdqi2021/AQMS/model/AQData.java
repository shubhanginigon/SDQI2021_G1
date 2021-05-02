package com.sdqi2021.AQMS.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AQData {
    private String station_id;
    private String station_name;
    private String area;
    private String station_type;
    private double latitude;
    private double longitude;
    private int pm_value;
    private String province;
    private String date_time;
}
