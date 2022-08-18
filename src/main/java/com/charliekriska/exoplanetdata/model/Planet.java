package com.charliekriska.exoplanetdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Planet {
    private String name;
    private String hostName;
    private String planetLetter;
    private String discoveryMethod;
    private int discoveryYear;
    private double orbitalPeriod;
    private double orbitSemiMajAxis;
    private double radius;
    private double mass;
    private double density;
    private double eccentricity;
    private double temperature;
}
