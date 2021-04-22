package com.sdqi2021.AQMS.model.dataModel;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    @Id
    private String stationID;
    private String nameTH;
    private String nameEN;
    private String areaTH;
    private String areaEN;
    private String stationType;
    private String lat;
    private String longitude;

    @Embedded
    private LastUpdate lastUpdate;
}
