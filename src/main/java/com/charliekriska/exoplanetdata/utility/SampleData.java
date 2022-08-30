package com.charliekriska.exoplanetdata.utility;

import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SampleData {

    public PlanetDto getPlanetDto() {
        return PlanetDto.builder()
                .pl_name("Planet 1")
                .hostname("hostname 1")
                .pl_letter("a")
                .discoverymethod("transit")
                .disc_year(2022)
                .pl_orbper(12.34)
                .pl_orbsmax(23.45)
                .pl_rade(34.56)
                .pl_bmasse(45.67)
                .pl_dens(56.78)
                .pl_orbeccen(0.5)
                .pl_eqt(273.4)
                .build();
    }

    public List<PlanetDto> getSamplePlanetDtoList() {
        PlanetDto dto1 = getPlanetDto();
        PlanetDto dto2 = getPlanetDto();
        dto2.setPl_name("Planet 2");
        dto2.setHostname("hostname 2");
        dto2.setPl_letter("b");
        dto2.setDisc_year(2021);
        return List.of(dto1, dto2);
    }

    public StarDto getStarDto() {
        return StarDto.builder()
                .hostname("hostname 1")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .build();
    }

    public List<StarDto> getSampleStarDtoList() {
        StarDto dto1 = getStarDto();
        StarDto dto2 = getStarDto();
        dto2.setHostname("hostname 2");
        return List.of(dto1, dto2);
    }

    public List<StarDto> getSampleStarDtoListWithDuplicates() {
        StarDto dto1 = getStarDto();
        StarDto dto2 = getStarDto();
        dto2.setHostname("hostname 2");
        StarDto dto3 = getStarDto();
        return List.of(dto1, dto2, dto3);
    }

    public StarSystemDto getStarSystemDto() {
        return StarSystemDto.builder()
                .hostname("hostname 1")
                .st_spectype("M")
                .st_teff(12.34)
                .st_rad(23.45)
                .st_mass(34.56)
                .st_met(45.67)
                .st_metratio("[]")
                .st_lum(0.5)
                .st_age(273.4)
                .sy_dist(5.9)
                .ra(1.2)
                .pl_name("Earth")
                .build();
    }

    public List<StarSystemDto> getSampleStarSystemDtoList() {
        StarSystemDto dto1 = getStarSystemDto();
        StarSystemDto dto2 = getStarSystemDto();
        dto2.setHostname("hostname 2");
        dto2.setRa(2.7);
        return List.of(dto1, dto2);
    }

    public List<StarSystemDto> getStarSystemDtoListDuplHostsMultPlanets() {
        StarSystemDto dto1 = getStarSystemDto();
        StarSystemDto dto2 = getStarSystemDto();
        dto2.setPl_name("Mars");
        StarSystemDto dto3 = getStarSystemDto();
        dto3.setPl_name("Jupiter");
        StarSystemDto dto4 = getStarSystemDto();
        dto4.setHostname("hostname 2");
        dto4.setPl_name("Kepler-17 b");
        return List.of(dto1, dto2, dto3, dto4);
    }

}
