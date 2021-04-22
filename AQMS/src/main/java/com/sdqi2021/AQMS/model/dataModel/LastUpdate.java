package com.sdqi2021.AQMS.model.dataModel;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class LastUpdate {
    private String date;
    private String time;

    @Embedded
    private PM25 PM25;
}
