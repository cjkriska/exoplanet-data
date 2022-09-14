package com.charliekriska.exoplanetdata.utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CalculationsUtil {

    public double calcCartX(double glat, double glon, double distance) {
        return -distance*Math.cos(Math.toRadians(glat))*Math.sin(Math.toRadians(glon));
    }

    public double calcCartY(double glat, double glon, double distance) {
        return distance*Math.cos(Math.toRadians(glat))*Math.cos(Math.toRadians(glon));
    }

    public double calcCartZ(double glat, double glon, double distance) {
        return distance*Math.sin(Math.toRadians(glat));
    }

}
