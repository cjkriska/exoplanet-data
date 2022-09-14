package com.charliekriska.exoplanetdata.transformer;

import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import com.charliekriska.exoplanetdata.utility.CalculationsUtil;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ExoPlanetTransformer {

    private final double PARSEC_MULTIPLIER = 3.26156;

    // --- Transformers ---------------------------------
    public Planet planetDtoToPlanet(PlanetDto dto) {
        return Planet.builder()
                .name(dto.getPl_name())
                .hostName(dto.getHostname())
                .planetLetter(dto.getPl_letter())
                .discoveryMethod(dto.getDiscoverymethod())
                .discoveryYear(dto.getDisc_year())
                .orbitalPeriod(dto.getPl_orbper())
                .orbitSemiMajAxis(dto.getPl_orbsmax())
                .radius(dto.getPl_rade())
                .mass(dto.getPl_bmasse())
                .density(dto.getPl_dens())
                .eccentricity(dto.getPl_orbeccen())
                .temperature(dto.getPl_eqt())
                .build();
    }
    public Star starDtoToStar(StarDto dto) {
        return Star.builder()
                .name(dto.getHostname())
                .specType(dto.getSt_spectype())
                .temperature(dto.getSt_teff())
                .radius(dto.getSt_rad())
                .mass(dto.getSt_mass())
                .stellarMetallicity(dto.getSt_met())
                .metallicityRatio(dto.getSt_metratio())
                .luminosity(dto.getSt_lum())
                .age(dto.getSt_age())
                .density(dto.getSt_dens())
                .rotationalPeriod(dto.getSt_rotp())
                .radialVelocity(dto.getSt_radv())
                .build();
    }
    public StarSystem starSystemDtoToStarSystem(StarSystemDto dto) {
        return StarSystem.builder()
                .host(starBuilder(dto))
                .rightAscension(dto.getRa())
                .declination(dto.getDec())
                .galacticLatitude(dto.getGlat())
                .galacticLongitude(dto.getGlon())
                .eclipticLatitude(dto.getElat())
                .eclipticLongitude(dto.getElon())
                .cartX(CalculationsUtil.calcCartX(dto.getGlat(), dto.getGlon(), convertParsecsToLightYears(dto.getSy_dist())))
                .cartY(CalculationsUtil.calcCartY(dto.getGlat(), dto.getGlon(), convertParsecsToLightYears(dto.getSy_dist())))
                .cartZ(CalculationsUtil.calcCartZ(dto.getGlat(), dto.getGlon(), convertParsecsToLightYears(dto.getSy_dist())))
                .distance(convertParsecsToLightYears(dto.getSy_dist()))
                .numPlanets(dto.getSy_pnum())
                .numStars(dto.getSy_snum())
                .numMoons(dto.getSy_mnum())
                .planets(List.of(planetBuilder(dto)))
                .build();
    }

    // --- Utility Methods --------------------------------
    private Planet planetBuilder(StarSystemDto dto) {
        return Planet.builder()
                .name(dto.getPl_name())
                .hostName(dto.getHostname())
                .planetLetter(dto.getPl_letter())
                .discoveryMethod(dto.getDiscoverymethod())
                .discoveryYear(dto.getDisc_year())
                .orbitalPeriod(dto.getPl_orbper())
                .orbitSemiMajAxis(dto.getPl_orbsmax())
                .radius(dto.getPl_rade())
                .mass(dto.getPl_bmasse())
                .density(dto.getPl_dens())
                .eccentricity(dto.getPl_orbeccen())
                .temperature(dto.getPl_eqt())
                .build();
    }
    private Star starBuilder(StarSystemDto dto) {
        return Star.builder()
                .name(dto.getHostname())
                .specType(dto.getSt_spectype())
                .temperature(dto.getSt_teff())
                .radius(dto.getSt_rad())
                .mass(dto.getSt_mass())
                .stellarMetallicity(dto.getSt_met())
                .metallicityRatio(dto.getSt_metratio())
                .luminosity(dto.getSt_lum())
                .age(dto.getSt_age())
                .density(dto.getSt_dens())
                .rotationalPeriod(dto.getSt_rotp())
                .radialVelocity(dto.getSt_radv())
                .build();
    }

    private double convertParsecsToLightYears(double parsecs) {
        return parsecs * PARSEC_MULTIPLIER;
    }
}
