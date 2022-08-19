package com.charliekriska.exoplanetdata.controller;

import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import com.charliekriska.exoplanetdata.service.ExoPlanetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class ExoplanetController {

    private final ExoPlanetService exoPlanetService;

    public ExoplanetController(ExoPlanetService exoPlanetService) {
        this.exoPlanetService = exoPlanetService;
    }

    @GetMapping("/planets")
    public List<Planet> getAllPlanets() {
        return exoPlanetService.getAllPlanets();
    }

    @GetMapping("/stars")
    public List<Star> getAllStars() {
        return exoPlanetService.getAllStars();
    }

    @GetMapping("/systems")
    public List<StarSystem> getAllSystems() {
        return exoPlanetService.getAllSystems();
    }

    @GetMapping("/test")
    public String testArrayNum() {
        System.out.println(exoPlanetService.getAllPlanets().size());
        System.out.println(exoPlanetService.getAllStars().size());
        System.out.println(exoPlanetService.getAllSystems().size());
        String result = "";
        return result;
    }
}
