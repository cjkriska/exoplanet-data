package com.charliekriska.exoplanetdata.dao;

import com.charliekriska.exoplanetdata.dto.PlanetDto;
import com.charliekriska.exoplanetdata.dto.StarDto;
import com.charliekriska.exoplanetdata.dto.StarSystemDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExoPlanetDao {
    List<PlanetDto> getAllPlanetData();
    List<StarDto> getAllStarData();
    List<StarSystemDto> getAllStarSystemData();
}
