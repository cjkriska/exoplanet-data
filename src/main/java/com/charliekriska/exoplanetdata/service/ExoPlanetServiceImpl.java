package com.charliekriska.exoplanetdata.service;

import com.charliekriska.exoplanetdata.dao.ExoPlanetDao;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.model.Planet;
import com.charliekriska.exoplanetdata.model.Star;
import com.charliekriska.exoplanetdata.model.StarSystem;
import com.charliekriska.exoplanetdata.transformer.ExoPlanetTransformer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ExoPlanetServiceImpl implements ExoPlanetService {

    private ExoPlanetDao exoPlanetDao;

    public ExoPlanetServiceImpl(ExoPlanetDao exoPlanetDao) {
        this.exoPlanetDao = exoPlanetDao;
    }

    @Override
    public List<Planet> getAllPlanets() {
        return exoPlanetDao.getAllPlanetData().stream()
                .map(ExoPlanetTransformer::planetDtoToPlanet)
                .collect(Collectors.toList());
    }

    @Override
    public List<Star> getAllStars() {
        return exoPlanetDao.getAllStarData().stream()
                .filter(distinctByKey(StarDto::getHostname))
                .map(ExoPlanetTransformer::starDtoToStar)
                .collect(Collectors.toList());
    }

    @Override
    public List<StarSystem> getAllSystems() {
        HashMap<String,List<Planet>> hostPlanetsMap = new HashMap<>();
        return exoPlanetDao.getAllStarSystemData().stream()
                .map(starSystemDto -> {
                    StarSystem starSystem = ExoPlanetTransformer.starSystemDtoToStarSystem(starSystemDto);
                    String hostName = starSystem.getHost().getName();
                    Planet planet = starSystem.getPlanets().get(0);
                    List<Planet> planets = hostPlanetsMap.get(hostName);
                    if(planets == null) {
                        planets = new ArrayList<>();
                    }
                    planets.add(planet);
                    hostPlanetsMap.put(hostName,planets);
                    return starSystem;
                })
                .filter(distinctByKey(starSystem -> starSystem.getHost().getName()))
                .map(starSystem -> {
                    starSystem.setPlanets(hostPlanetsMap.get(starSystem.getHost().getName()));
                    return starSystem;
                })
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
