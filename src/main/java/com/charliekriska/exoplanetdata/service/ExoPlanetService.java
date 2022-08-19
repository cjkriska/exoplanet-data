package com.charliekriska.exoplanetdata.service;

import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExoPlanetService {
    List<Planet> getAllPlanets();
    List<Star> getAllStars();
    List<StarSystem> getAllSystems();
}
