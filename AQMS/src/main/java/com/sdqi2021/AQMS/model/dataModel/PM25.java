package com.sdqi2021.AQMS.model.dataModel;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class PM25 {
    private String value;
    private String unit;
}
