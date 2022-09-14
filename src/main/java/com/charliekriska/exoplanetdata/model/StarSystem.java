package com.charliekriska.exoplanetdata.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StarSystem {
    private Star host;
    private double rightAscension;
    private double declination;
    private double galacticLatitude;
    private double galacticLongitude;
    private double eclipticLatitude;
    private double eclipticLongitude;
    private double cartX;
    private double cartY;
    private double cartZ;
    private double distance;
    private int numPlanets;
    private int numStars;
    private int numMoons;
    private List<Planet> planets;
}
