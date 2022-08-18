package com.charliekriska.exoplanetdata.controller;

import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class ExoplanetController {

    @GetMapping("/planets")
    public List<Planet> getAllPlanets() {
        return serviceGetAllPlanets();
    }

    @GetMapping("/stars")
    public List<Star> getAllStars() {
        return serviceGetAllStars();
    }

    @GetMapping("/systems")
    public List<StarSystem> getAllSystems() {
        return serviceGetAllStarSystems();
    }

    // ---------- Sample: Delete all below code after service is created -----------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    private List<Planet> serviceGetAllPlanets() {
        return List.of(getPlanetA(), getPlanetB());
    }
    private List<Star> serviceGetAllStars() {
        return List.of(getStarA(), getStarB());
    }
    private List<StarSystem> serviceGetAllStarSystems() {
        return List.of(getStarSystemA(), getStarSystemB());
    }


    private Planet getPlanetA() {
        return Planet.builder()
                .name("Proxima Centauri b")
                .hostName("Alpha Centauri")
                .planetLetter("b")
                .discoveryMethod("Radial Velocity")
                .discoveryYear(2015)
                .orbitalPeriod(43.21)
                .orbitSemiMajAxis(12.34)
                .radius(1.2)
                .mass(2.1)
                .density(4.3)
                .eccentricity(.83)
                .temperature(279.2)
                .build();
    }
    private Planet getPlanetB() {
        return Planet.builder()
                .name("Kepler-1a")
                .hostName("Kepler-1")
                .planetLetter("a")
                .discoveryMethod("Transit")
                .discoveryYear(2010)
                .orbitalPeriod(4.21)
                .orbitSemiMajAxis(34.21)
                .radius(1.3)
                .mass(24)
                .density(4.4)
                .eccentricity(.76)
                .temperature(212.2)
                .build();
    }
    private Star getStarA() {
        return Star.builder()
                .name("Sun")
                .specType("M")
                .temperature(2345.23)
                .radius(43.2)
                .mass(5445454.2)
                .stellarMetallicity(343.2)
                .metallicityRatio(.34)
                .luminosity(2.1)
                .age(43)
                .density(23.3)
                .rotationalPeriod(3.2)
                .radialVelocity(4.7)
                .build();
    }
    private Star getStarB() {
        return Star.builder()
                .name("Vega")
                .specType("K")
                .temperature(43435.23)
                .radius(3.2)
                .mass(44545455.2)
                .stellarMetallicity(43.2)
                .metallicityRatio(.94)
                .luminosity(1.1)
                .age(3)
                .density(13.8)
                .rotationalPeriod(2.2)
                .radialVelocity(7.7)
                .build();
    }
    private StarSystem getStarSystemA() {
        return StarSystem.builder()
                .host(getStarA())
                .rightAscension(5.32)
                .declination(1.6)
                .galacticLatitude(45.2)
                .galacticLongitude(34.5)
                .eclipticLatitude(76.3)
                .eclipticLongitude(98.3)
                .distance(4.7)
                .planets(List.of(getPlanetA(), getPlanetB()))
                .build();
    }
    private StarSystem getStarSystemB() {
        return StarSystem.builder()
                .host(getStarB())
                .rightAscension(4.32)
                .declination(0.6)
                .galacticLatitude(5.2)
                .galacticLongitude(4.5)
                .eclipticLatitude(6.3)
                .eclipticLongitude(198.3)
                .distance(674.7)
                .planets(List.of(getPlanetB(), getPlanetA()))
                .build();
    }



}
