package com.palash.energysaving.Entity;


import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "chart_data")
@Setter
@Getter
public class Energy {
    @Id
    private ObjectId _id;
    private Date createdAt;
    private String serialNo;
    private ObjectId clientID;
    private ObjectId deviceMapID;
    private ObjectId[] devices;
    private BigDecimal total_kwh;
    private Date updatedAt;
    private BigDecimal ac_run_hrs;
    private BigDecimal fan_run_hrs;
    private int algo_status;
    private double billing_ammount;
    private double cost_reduction;
    private energy_savings energySavings;
    private long mitigated_co2;
    private weather weather;
}

@Getter
@Setter
class energy_savings{
    private double savings_percent;
    private BigDecimal ref_kwh;
    private long us_meter;
    private long us_calc;
    private long inv_factor;
}

@Getter
@Setter
class weather{
    private double max_temp;
    private double min_temp;
}