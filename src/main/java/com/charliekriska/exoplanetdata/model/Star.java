package com.charliekriska.exoplanetdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Star {
    private String name;
    private String specType;
    private double temperature;
    private double radius;
    private double mass;
    private double stellarMetallicity;
    private double metallicityRatio;
    private double luminosity;
    private double age;
    private double density;
    private double rotationalPeriod;
    private double radialVelocity;
}
