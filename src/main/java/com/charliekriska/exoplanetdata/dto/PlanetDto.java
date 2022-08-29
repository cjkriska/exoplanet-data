package com.charliekriska.exoplanetdata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDto {
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
}
