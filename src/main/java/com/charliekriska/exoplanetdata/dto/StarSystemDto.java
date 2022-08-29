package com.charliekriska.exoplanetdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarSystemDto {
    private String pl_name;
    private String hostname;
    private String pl_letter;
    private String discoverymethod;
    private int disc_year;
    private double pl_orbper;
    private double pl_orbsmax;
    private double pl_rade;
    private double pl_bmasse;
    private double pl_dens;
    private double pl_orbeccen;
    private double pl_eqt;
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
    private double ra;
    private double dec;
    private double glat;
    private double glon;
    private double elat;
    private double elon;
    private int sy_snum;
    private int sy_pnum;
    private int sy_mnum;
}
