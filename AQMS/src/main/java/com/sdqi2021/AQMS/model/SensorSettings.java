package com.sdqi2021.AQMS.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settingsId;

    private boolean serverRunning;

    private int refreshIntervalSeconds;

    private Date lastUpdated;
}
