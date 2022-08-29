package com.charliekriska.exoplanetdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarDto {
    private String hostname;
    private String st_spectype;
    private double st_teff;
    private double st_rad;
    private double st_mass;
    private double st_met;
    private String st_metratio;
    private double st_lum;
    private double st_age;
    private double st_dens;
    private double st_rotp;
    private double st_radv;
    private double sy_dist;
}